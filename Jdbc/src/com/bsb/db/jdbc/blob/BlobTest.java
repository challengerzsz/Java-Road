package com.bsb.db.jdbc.blob;


import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class BlobTest {
    JFrame jFrame = new JFrame("图片管理");
    private static Connection connection;
    private static PreparedStatement insert;
    private static PreparedStatement query;
    private static PreparedStatement queryALL;
    //定义一个
    private DefaultListModel<ImageHolder> imageModel = new DefaultListModel<>();
    private JList<ImageHolder> imageList = new JList<>();
    private JTextField filePath = new JTextField(26);
    private JButton browserBn = new JButton("...");
    private JButton uploadBn = new JButton("上传");
    private JLabel imageLabel = new JLabel();
    //以当前路径为文件选择器
    JFileChooser chooser = new JFileChooser(".");
    //创建文件过滤器
    ExtensionFileFilter filter = new ExtensionFileFilter();

    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("E:\\Java-Road\\Jdbc\\src\\jdbc.properties"));
            String driver = properties.getProperty("JDBC_DRIVER");
            String url = properties.getProperty("URL");
            String user = properties.getProperty("USER");
            String pwd = properties.getProperty("PWD");

            Class.forName(driver);
            connection = DriverManager.getConnection(url, user, pwd);
            //返回插入后自动生成的主键
            insert = connection.prepareStatement("insert into img_table VALUES (NULL, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            query = connection.prepareStatement("select img_date from img_table WHERE img_id = ?");
            queryALL = connection.prepareStatement("select img_id, img_name from img_table");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        //初始化文件选择器
        filter.addExtension("jpg");
        filter.addExtension("jpeg");
        filter.addExtension("png");
        filter.addExtension("gif");

        filter.setDescription("图片文件(*.jpg,*.png,*.jpeg,*.gif)");
        chooser.addChoosableFileFilter(filter);

        //进制文件类型下拉列表显示所有文件选项
        chooser.setAcceptAllFileFilterUsed(false);

        //初始化界面
        fillListModel();
        filePath.setEditable(false);
        //只能单选
        imageList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        JPanel jPanel = new JPanel();
        jPanel.add(filePath);
        jPanel.add(browserBn);
        browserBn.addActionListener(event -> {
            //显示文件对话框
            int result = chooser.showDialog(jFrame, "浏览图片文件上传");
            //如果用户选择了APPROVE按钮 打开 保存等效按钮
            if (result == JFileChooser.APPROVE_OPTION) {
                filePath.setText(chooser.getSelectedFile().getPath());
            }
        });
        jPanel.add(uploadBn);
        uploadBn.addActionListener(avt -> {
            //如果上传文件文本框有内容
            if (filePath.getText().trim().length() > 0) {
                //将指定文件保存到数据库
                upload(filePath.getText());
                //清空文本框内容
                filePath.setText("");
            }
        });
        JPanel left = new JPanel();
        left.setLayout(new BorderLayout());
        left.add(new JScrollPane(imageLabel), BorderLayout.CENTER);
        left.add(jPanel, BorderLayout.SOUTH);
        jFrame.add(left);
        imageList.setFixedCellWidth(160);
        jFrame.add(new JScrollPane(imageList), BorderLayout.EAST);
        imageList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //双击
                if (e.getClickCount() >= 2) {
                    //取出选中List项
                    ImageHolder cur = imageList.getSelectedValue();
//                    System.out.println(cur.getId() + cur.getName());
                    try {
                        //显示选中项对应的Image
                        showImage(cur.getId());
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
        jFrame.setSize(620, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    //根据id显示图片
    public void showImage(int id) throws SQLException {
        //设置参数
        query.setInt(1, id);
        try (
                //执行查询
                ResultSet resultSet = query.executeQuery()
                ){
            if (resultSet.next()) {
                //取出Blob列
                Blob imgBlob = resultSet.getBlob(1);
                System.out.println(imgBlob);
                //取出Blob列数据
                ImageIcon icon = new ImageIcon(imgBlob.getBytes(1L,(int) imgBlob.length()));
                imageLabel.setIcon(icon);
            }
        }
    }

    //将指定图片放入数据库
    private void upload(String fileName) {
        //截取文件名
        String imageName = fileName.substring(fileName.lastIndexOf('\\') + 1, fileName.lastIndexOf('.'));
        File file = new File(fileName);
        try (
                InputStream inputStream = new FileInputStream(file)
                ){
            //设置图片名参数
            insert.setString(1, imageName);
            insert.setBinaryStream(2, inputStream, (int)file.length());
            int affect = insert.executeUpdate();
            if (affect == 1) {
                //重新更新ListModel 更新最新的图片列表
                fillListModel();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //查找img_table填充ListModel
    private void fillListModel() {
        try (
                ResultSet resultSet = queryALL.executeQuery()
                ) {
            //清除所有元素
            imageModel.clear();
            //将查询到的所有记录都放在ListModel中
            while (resultSet.next()) {
                imageModel.addElement(new ImageHolder(resultSet.getInt(1),
                        resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


class ExtensionFileFilter extends FileFilter{

    private String description = "";
    private ArrayList<String> extensions = new ArrayList<>();

    //添加文件拓展名
    public void addExtension(String extension) {
        if (!extension.startsWith(".")) {
            extension = "." + extension;
            extensions.add(extension);
        }
    }

    //用来设置该文件过滤器描述文本
    public void setDescription(String adescription) {
        description = adescription;
    }

    @Override
    public boolean accept(File f) {
        //如果该文件是路径 接收
        if (f.isDirectory()) return true;
        //将文件名转为小写
        String name = f.getName().toLowerCase();
        //遍历所有可接受的拓展名，如拓展名相同，文件可接收
        for (String extension : extensions) {
            if (name.endsWith(extension)) return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        new BlobTest().init();
    }
}


//封装图片名、图片ID
class ImageHolder {
    //封装图片ID
    private int id;
    private String name;

    public ImageHolder() {}

    public ImageHolder(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
