/*
package com.test.controller;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;




public class CaijiController {
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";

        BufferedInputStream bufr = null;

        String url = "jdbc:mysql://localhost:3306/weixin?serverTimezone=UTC";
        String user = "root";
        String pwd = "root";

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, user, pwd);
            Statement stet = con.createStatement();
            String sql = "select * from article1";
            ResultSet rs = stet.executeQuery(sql);
            int countss = 0;
            while (rs.next()) {
                countss++;

            }
            System.out.println(countss);
            int pageSize = 30;
// 查询文章总条数

            int totalPage = countss / pageSize;
            if (countss % pageSize > 0) {
                totalPage++;
            }
            int ace = 0;
            int sd = 0;
            int error = 0;
            for(int i = 1; i <= totalPage; i++){
                String sqlCount = " SELECT COUNT(*) FROM article1";
                ResultSet count = stet.executeQuery(sqlCount);
                String sqlTwo = "select name,title,publish_time,url,cover_image,content,src_html,tag from article1 where content != \"\" LIMIT "+ace+","+30;
                System.out.println( sqlTwo);
                ace = ace+30;

                System.out.println( ace);
                ResultSet rse = stet.executeQuery(sqlTwo);
                ResultSetMetaData metaData = rse.getMetaData();
                int columnCount = metaData.getColumnCount();

                JSONArray array = new JSONArray();

                while (rse.next()) {
                    JSONObject jsonObj = new JSONObject();
                    for (int a = 1; a <= columnCount; a++) {

                        String columnName = metaData.getColumnLabel(a);
                        String value = rse.getString(columnName);
                        jsonObj.put(columnName, value);
                    }
                    array.put(jsonObj);
                }

                Date date = new Date();
                String time = new SimpleDateFormat("yyyyMMdd").format(date);
                //文件夹地址
                String pathTwo="D:\\caiji\\"+time;
                File f = new File(pathTwo);
                //判断是否创建了文件夹
                if(!f.exists()){
                    f.mkdirs();
                }
                String dataForm = new SimpleDateFormat("yyyyMMddhhmmss").format(date);
                String arrayCaiji = array.toString();
                System.out.println( "字节大小"+arrayCaiji.length());
                //文件存放地址
                if(arrayCaiji.length()>100){
                    //设置暂停的时间 2 秒
                    Thread.sleep(2 * 1000);
                    //BufferedWriter fileWriter = new BufferedWriter();
                    //FileWriter fileWriter = new FileWriter("D:\\caiji\\"+time+"\\"+dataForm+".txt");
                    FileInputStream fileInputStream = new FileInputStream(arrayCaiji);
                    bufr = new BufferedInputStream(fileInputStream);
                    // 读取对应的文件内容
                    byte[] b = new byte[1024];
                    int len = 0;
                    while ((len = bufr.read(b)) != -1) {
                        // 6将读取内容写到目标地点

                    }
                    if (bufr != null) {
                        try {
                            bufr.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    FileReader fileReader = new FileReader("D:\\caiji\\"+time+"\\20200429112108.txt");
                    //fileWriter.write(arrayCaiji);
                    //fileWriter.flush();
                }else{
                    error=error+1;
                    System.out.println( "错误sql"+error+"次");
                }

            }
            con.close();
        } catch (Exception e) {

            e.printStackTrace();// TODO: handle exception
        }

    }





}
*/
