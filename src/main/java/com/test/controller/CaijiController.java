package com.test.controller;


import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;




public class CaijiController {
    public static void main(String[] args) {
        String driver = "com.mysql.jdbc.Driver";



        String url = "jdbc:mysql://localhost:3306/weixin?serverTimezone=UTC";
        String user = "root";
        String pwd = "root";

    try {
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, pwd);
        Statement stet = con.createStatement();
        String sql = "select * from article2";
        //执行sql
        ResultSet rs = stet.executeQuery(sql);
        int countss = 0;
        while (rs.next()) {
            countss++;
        }
        int pageSize = 30;
        // 查询文章总条数
        int totalPage = countss / pageSize;
        if (countss % pageSize > 0) {
            totalPage++;
        }
            //设置查询页数 否则数据太多
            int ace = 0;
            for(int i = 1; i <= totalPage; i++){
            String sqlCount = " SELECT COUNT(*) FROM article2";
            ResultSet count = stet.executeQuery(sqlCount);
            String sqlTwo = "select name,title,publish_time,url,cover_image,content,src_html,tag from article2 where content != \"\" LIMIT "+ace+","+30;
            //添加页数 查询下一页
            ace = ace+30;
            ResultSet rse = stet.executeQuery(sqlTwo);
            ResultSetMetaData metaData = rse.getMetaData();
            //总条数
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
            String dataForm = new SimpleDateFormat("yyyyMMddhhmmss").format(date);
            //文件夹地址
            String pathTwo="D:\\caiji\\"+time;
            //临时文件目录
            String path = "D:\\caiji\\caijitest\\"+dataForm+".txt";
            //目标目录
            String pathUrl = "D:\\caiji\\"+time+"\\"+dataForm+".txt";
            File f = new File(pathTwo);
            //判断是否创建了文件夹
            if(!f.exists()){
                f.mkdirs();
            }
                String arrayCaiji = array.toString();
            if(arrayCaiji.length()>100){
                File file = new File(path);
                File fileTwo = new File(pathUrl);
                //设置暂停的时间 2秒
                Thread.sleep(2 * 1000);
                FileWriter fileWriter = new FileWriter(path);
                fileWriter.write(arrayCaiji);
                //移动文件前关闭当前执行io流 否则无法删除生成文件
                fileWriter.close();
                try {
                    //将文件移动到日表目录
                    FileUtils.moveFile(file,fileTwo);
                    } catch (Exception e) {
                            e.printStackTrace();
                            System.out.println(e.getMessage());
                    }

                //fileWriter.flush();
            }else{
                System.out.println( "数据过小");
                break;
            }

        }
        } catch (Exception e) {

        e.printStackTrace();
        }

    }
}
