package net.projectGroup2.controllers;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;
import javax.servlet.ServletConfig;

import java.io.File;
import java.io.FileOutputStream;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.*;

import net.projectGroup2.form.LoginForm;
import net.projectGroup2.form.UploadItem;
import net.projectGroup2.model.Pictures;
import net.projectGroup2.model.Users;

import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "/uploadfile")
public class UploadFileController {
	private String uploadFolderPath;
	ServletConfig config;

	public String fileName = null;
	public String y = null;
    @Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
           return sessionFactory.openSession();
    }
    
    
	public String getUploadFolderPath() {
		return uploadFolderPath;
	}

	public void setUploadFolderPath(String uploadFolderPath) {
		this.uploadFolderPath = uploadFolderPath;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getUploadForm(Model model) {
		model.addAttribute(new UploadItem());
		return "/uploadfile";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String create(UploadItem uploadItem, BindingResult result,
			HttpServletRequest request, HttpServletResponse response, Map model) {
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.err.println("Error: " + error.getCode() + " - "
						+ error.getDefaultMessage());
			}
			return "/uploadfile";
		}
		
		String filePath = null;

		// Some type of file processing...
		System.err.println("-------------------------------------------");
		try {
			MultipartFile file = uploadItem.getFileData();
			
			InputStream inputStream = null;
			OutputStream outputStream = null;
			if (file.getSize() > 0) {
				inputStream = file.getInputStream();
				if (file.getSize() > 10000) {
					System.out.println("File Size:::" + file.getSize());
					return "/uploadfile";
				}
				System.out.println("size::" + file.getSize());
				fileName = request.getRealPath("") + "/images/"
						+ file.getOriginalFilename();
				HttpSession session = request.getSession();
				System.out.println(session.getAttribute("test"));
				y = (String) session.getAttribute("test");
				/*Session session1 = sessionFactory.openSession();
				session1.beginTransaction();*/
				Users users = new Users();
				Pictures pic = new Pictures();
				
				
			
			      
				/*String hql = "INSERT INTO Users()"  + 
			             "SELECT firstName, lastName, salary FROM old_employee";
			Query query = session.createQuery(hql);
			int result = query.executeUpdate();
			System.out.println("Rows affected: " + result);
				*/
				
				
				
				//session.setAttribute("fileName", file.getOriginalFilename());
				outputStream = new FileOutputStream(fileName);
				System.out.println("fileName:" + file.getOriginalFilename());
				System.out.println("iiiiiiiiiii");
				System.out.println(fileName);
				filePath = (fileName.split("/")[0]).replaceAll("\\\\", "/");
				System.out.println(filePath+"images/");
				/*System.out.println("getContextPath: "+request.getContextPath());
				System.out.println("getPathInfo: "+request.getPathInfo());
				System.out.println("getPathTranslated: "+request.getPathTranslated());*/
				System.out.println("ppppppppp");
				int readBytes = 0;
				byte[] buffer = new byte[10000];
				while ((readBytes = inputStream.read(buffer, 0, 10000)) != -1) {
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
			}

			// ..........................................
			Session session1 = sessionFactory.openSession();
			session1.beginTransaction();
			Pictures pics = new Pictures();
			pics.setUserName(y);
			//pics.setPic(file.getOriginalFilename());
			/*Users users = new Users();
			users.setUserName(fileName);*/
			String z = file.getOriginalFilename();
			//pics.setPic(z);
			//System.out.println(y);
			/*String x = "one";*/
			/*users.setUserPassword(x);*/
		/*	users.setUserPassword(userPassword);*/
		
			/*session1.save(users);*/
			
			 File f = null;
		      File f1 = null;
			  File f2 = null;
			  File f3 = null;
		      boolean bool = false;
		      
		      f = new File(fileName);
			  String file1 = f.getName().toString();
		      //System.out.println(f);
		      //f1 = new File("S:/Users/Maaz/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/springmvcloginhibernate/images/" + file.getOriginalFilename());
			  f1 = new File(filePath+ "images/" + file.getOriginalFilename());
		      
		      f2 = new File(y + ".jpg");
		      String file2 = f2.getName().toString();
		      System.out.println("ddddddd" + file2);
		      System.out.println("ddddddd" + f1);
		      f3 = new File(filePath+ "images/" + file2 );
		      System.out.println("New file name:" + f3);
			  pics.setPic(file2);
			  System.out.println(f1);
		     /* if(f.renameTo(f1)) {
		          System.out.println("renamed");
		       } else {
		          System.out.println("Error");
		       }*/
		      
			  if(f1.renameTo(f3)) {
		          System.out.println("renamed");
		       } else {
		          System.out.println("Error");
		       }
		      
			
			session1.save(pics);
			session1.getTransaction().commit();
			session1.close();
			
			//session.setAttribute("uploadFile", file.getOriginalFilename());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
		//return "redirect:/forms/uploadfileindex";
	}

}
