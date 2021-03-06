package edu.ucam.database;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import edu.ucam.classes.Comment;
import edu.ucam.classes.Product;
import edu.ucam.classes.User;
import edu.ucam.classes.Vote;

public class LoadData {

	public static void loadProducts(String contextPath, ArrayList<Product> products) {
				
		try {
            File file = new File(contextPath + "/WebContent/database/products.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList productsList =  document.getElementsByTagName("product");
            
            for (int i = 0; i < productsList.getLength(); ++i) {
                Node node = productsList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Product product = new Product();
                    product.setId(element.getElementsByTagName("id").item(0).getTextContent());
                    product.setName(element.getElementsByTagName("name").item(0).getTextContent());
                    product.setModel(element.getElementsByTagName("model").item(0).getTextContent());
                    product.setTrademark(element.getElementsByTagName("trademark").item(0).getTextContent());
                    product.setDescription(element.getElementsByTagName("description").item(0).getTextContent());
                    product.setImg_path(element.getElementsByTagName("img_path").item(0).getTextContent());
                    try{product.setPrice(Float.parseFloat(element.getElementsByTagName("price").item(0).getTextContent()));}
                    catch(Exception e){product.setPrice((float)0.0);}
                    
                    products.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return;
	}
	
	
	public static void loadUsers(String contextPath, ArrayList<User> users) {
		try {
            File file = new File(contextPath + "/WebContent/database/users.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList usersList =  document.getElementsByTagName("user");
            
            for (int i = 0; i < usersList.getLength(); ++i) {
                Node node = usersList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    User user = new User();
                    user.setId(element.getElementsByTagName("id").item(0).getTextContent());
                    user.setUsername(element.getElementsByTagName("username").item(0).getTextContent());
                    user.setEmail(element.getElementsByTagName("email").item(0).getTextContent());
                    user.setPassword(element.getElementsByTagName("password").item(0).getTextContent());
                    user.setBiography(element.getElementsByTagName("biography").item(0).getTextContent());
                    user.setAddress(element.getElementsByTagName("address").item(0).getTextContent());    
                    
                    users.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return;
	}
	
	public static void loadVotes(String contextPath, ArrayList<Vote> votes) {
		
		System.out.println(contextPath);
		
		try {
            File file = new File(contextPath + "/WebContent/database/votes.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList votesList =  document.getElementsByTagName("vote");
            
            for (int i = 0; i < votesList.getLength(); ++i) {
                Node node = votesList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Vote vote = new Vote();
                    vote.setId(element.getElementsByTagName("id").item(0).getTextContent());
                    vote.setAssessment(Integer.parseInt(element.getElementsByTagName("assessment").item(0).getTextContent()));
                    try{vote.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(element.getElementsByTagName("date").item(0).getTextContent()));}
                    catch(Exception t) {vote.setDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/0001"));}
                    vote.setProductId(element.getElementsByTagName("productId").item(0).getTextContent());
                    vote.setUserId(element.getElementsByTagName("userId").item(0).getTextContent());
                    
                    votes.add(vote);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return;
	}
	
	public static void loadComments(String contextPath, ArrayList<Comment> comments) {
		try {
            File file = new File(contextPath + "/WebContent/database/comments.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList commentsList =  document.getElementsByTagName("comment");
            
            for (int i = 0; i < commentsList.getLength(); ++i) {
                Node node = commentsList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    Comment comment = new Comment();
                    comment.setId(element.getElementsByTagName("id").item(0).getTextContent());
                    comment.setResume(element.getElementsByTagName("resume").item(0).getTextContent());
                    comment.setContent(element.getElementsByTagName("content").item(0).getTextContent());
                    comment.setVoteId(element.getElementsByTagName("voteId").item(0).getTextContent());
                    
                    comments.add(comment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return;
	}
	
	public static void loadDataBase(String contextPath, ArrayList<User> users, ArrayList<Product> products, ArrayList<Vote> votes, ArrayList<Comment> comments) {
		
		loadProducts(contextPath, products);
		loadUsers(contextPath, users);
		loadVotes(contextPath, votes);
		loadComments(contextPath, comments);
		
		return;
	}
}
