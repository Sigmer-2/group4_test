package com.zlk.group4.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * 图片上传工具类
 * User: sunshuai
 * Date: 2020-09-28
 * Time: 14:19
 */
public class ImgUtil {
    public static String addImg(MultipartFile file, HttpServletRequest request) throws IOException {
    String path = "D:\\会\\group4\\group4\\src\\main\\resources\\static\\houseimg"; // 文件存储绝对路径
        String pa = "static\\houseimg\\"; // 文件存储相对路径
        // 图片保存前缀
        String url = request.getSession().getServletContext().getRealPath("houseimg");

//		double fileSize = file.getSize();
//		System.out.println("文件的大小是" + fileSize);
//
//		byte[] sizebyte = file.getBytes();
//		System.out.println("文件的byte大小是" + sizebyte.toString());

        if (file != null) {// 判断上传的文件是否为空

            String type = null;// 文件类型
            String fileName = file.getOriginalFilename();// 文件原名称
//            System.out.println("上传的文件原名称:" + fileName);
            // 判断文件类型
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            if (type != null) {// 判断文件类型是否为空
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
//                    System.out.println("项目在容器中实际发布运行的根路径" + realPath);
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + "." + type;
//                    System.out.println("自定义的文件名称" + trueFileName);
                    // 设置存放图片文件的路径
                    path = path +"\\"+ trueFileName;
                    System.out.println("存放图片文件的路径:" + path);

                    //判断文件夹是否存在
                    File file1 = new File(url);
                    if (!file1.exists()) {
                        file1.mkdirs();
                    }

                    // 转存文件到指定的路径
                    file.transferTo(new File(path));
//                    System.out.println("文件成功上传到指定目录下");

//                    return pa + trueFileName;
                    return path;
                }

            } else {
//                System.out.println("不是我们想要的文件类型,请按要求重新上传");
//				return "不是我们想要的文件类型,请按要求重新上传";
                return null;
            }
        } else {
//            System.out.println("文件类型为空");
            return null;
        }
//		return "已经成功上传到指定目录";
        return null;
    }

}
