/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Ibrahiam
 */
public class LibrarySystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        System.out.println("\n==================================="+"\nWelcome to the Library"+"\n==================================="+"\n press \"1\" 1if you are a Head"+"\n press \"2\" 1if you are a Librarian"+ " \n press \"3\" if you are a member"+"\n===================================");
        Scanner input = new Scanner(System.in);
        int logIn = input.nextInt();
        
        
        
        
        
        
        
        
        
        while(logIn>3 ||logIn<1){
            System.out.println("Wrong choice , the input must be 1 or 2 or 3");
        logIn = input.nextInt();
        
        }
        if (logIn==1){
            //Head
            
                //password authintication
                Scanner headinput = new Scanner(System.in);
                 System.out.println("Enter a Head user name :");
        String headUserName = headinput.nextLine();
        File headUserNameFile =new File("d:/users database/heads", headUserName );
        boolean headUserNameFileExists =headUserNameFile.exists();
         while(!headUserNameFileExists){
            System.out.println("user name is incorrect , try again"+"\n===================================");
            headUserName = headinput.nextLine();
            headUserNameFile =new File("d:/users database/heads", headUserName );
            headUserNameFileExists =headUserNameFile.exists();
            
         }
            System.out.println("user name is correct"+"\n===================================");
            
            
        
            try{
                
                System.out.println("Enter a password for the Head "+headUserName);
                String inPassForhead = headinput.nextLine();
                Scanner readPassword = new Scanner(new FileInputStream("d:/users database/heads/"+headUserName));
                String read = readPassword.nextLine();
                readPassword.close();
               
                while(!read.equals(inPassForhead)){
                    System.out.println("Wrong password !! , try again"+"\n===================================");
                    inPassForhead = headinput.nextLine();
                    
                }
                    
                
                    System.out.println("correct password"+"\n===================================");
               
                    
                
                
                
            
            }
            catch(FileNotFoundException e){
                System.out.println("file was not found");
                
            }
                  //give the head choises
                System.out.println("press \"1\" to add new librarians"+"\npress \"2\" to show the books details "+"\npress \"3\" to show the members details"+"\npress \"4\" to show the librarians details"+"\n===================================");
                int headChoises = input.nextInt();
                switch(headChoises){
                    case 1:
                System.out.println("Set a new librarian user name:");
                 Scanner read = new Scanner(System.in);
        String fileName = read.nextLine();
        
        try{
            File user = new File("d:/users database/librarians/",fileName);
          
            user.createNewFile();
            System.out.println("a new librarian user name has been set"+"\n===================================");
        }catch (Exception e ){
            System.out.println("File was not created");
        }
       try{
           System.out.println("Set a password for the user "+fileName);
           String n = read.nextLine();
           PrintWriter writePass = new PrintWriter(new FileOutputStream("d:/users database/librarians/"+fileName));
           writePass.println(n);
           System.out.println("password for the librarian "+fileName+" has been set"+"\n===================================");
           writePass.close();
           System.exit(0);
        }
       catch(IOException e){
           System.out.println("password was not written");
       }
       break;
                    case 2:
                       File enterBookCategories = new File("d:/books database");
                        File listOfbooks[]=enterBookCategories.listFiles();
                         System.out.println("The categories are: "+"\n===================================");
                        for(int i =0 ; i<listOfbooks.length;i++){
                           
                            System.out.println((i+1)+"\" "+listOfbooks[i].getName()+"\"");
                        
                        }
                        Scanner inHead = new Scanner(System.in);
                        System.out.println("============================="+"\nChoose a ctegory to browse :");
                       
                        String inBookCategoryToBrowse = inHead.nextLine();
                        File inBookCategoryToBrowseF = new File("d:/books database/",inBookCategoryToBrowse);
                        while(!inBookCategoryToBrowseF.exists()){
                            System.out.println("you entered a wrong category !! .. try  again :"+"\n choose one of the follwoing categories: ");
                               for(int i =0 ; i<listOfbooks.length;i++){
                           
                            System.out.println((i+1)+"\" "+listOfbooks[i].getName()+"\"");
                        
                        }
                               System.out.println("\n===================================");
                         inBookCategoryToBrowse = inHead.nextLine();
                        inBookCategoryToBrowseF = new File("d:/books database/",inBookCategoryToBrowse);
                        
                        }
                         File book = new File(inBookCategoryToBrowseF.getPath());
                         File bookInfo[] = book.listFiles();
                         System.out.println("Books list:");
                          System.out.println("===================");
                         for(int i=0 ; i<bookInfo.length ; i++){
                             
                             System.out.println((i+1)+"\" "+bookInfo[i].getName());
                             File bookStatus = new File(bookInfo[i].getPath());
                             try{
                                 Scanner readBookStatus = new Scanner(new FileInputStream(bookStatus));
                                 String readFromTheBook = readBookStatus.nextLine();
                                 System.out.println("   "+readFromTheBook);
                                 System.out.println("");
                                 readBookStatus.close();
                             }catch(FileNotFoundException e){
                                 System.out.println("No Status");
                             }
                         }
                         System.out.println("===================");
                         break;
                    case 3:
                        File checkMembers = new File("d:/users database/members");
                        File listCheckMembers[] =  checkMembers.listFiles();
                        System.out.println("Users list :");
                         System.out.println("===================");
                        for(int i=0 ; i<listCheckMembers.length ; i++){
                            System.out.println((i+1)+"\" User name : "+listCheckMembers[i].getName());
                        try{
                            Scanner readUserPassword = new Scanner(new FileInputStream(listCheckMembers[i].getPath()));
                            String readUserPass = "   password : "+readUserPassword.nextLine();
                            System.out.println(readUserPass);
                            System.out.println("");
                            readUserPassword.close();
                        }catch(FileNotFoundException e){
                            System.out.println("No password to read!!!");
                        }
                        
                        }
                        System.out.println("===================");
                        break;
                    case 4:
                       
                         File checkLibrarians = new File("d:/users database/librarians");
                        File listCheckLibrarians[] =  checkLibrarians.listFiles();
                        System.out.println("Librarians list :");
                        System.out.println("===================");
                        for(int i=0 ; i<listCheckLibrarians.length ; i++){
                            System.out.println((i+1)+"\" librarian name : "+listCheckLibrarians[i].getName());
                        try{
                            Scanner readUserPassword = new Scanner(new FileInputStream(listCheckLibrarians[i].getPath()));
                            String readUserPass = "   password : "+readUserPassword.nextLine();
                            System.out.println(readUserPass);
                            System.out.println("");
                            readUserPassword.close();
                        }catch(FileNotFoundException e){
                            System.out.println("No password to read!!!");
                        }
                        
                        }
                        System.out.println("===================");
                        break;
        }
        }
         
            
                
                    
                        
                
               
                
                //Librarians
                else if(logIn==2){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a librarian user name :");
        String n = in.nextLine();
        File userName =new File("d:/users database/librarians", n );
        boolean exists =userName.exists();
         while(!exists){
            System.out.println("user name is incorrect , try again"+"\n===================================");
            n = in.nextLine();
            userName =new File("d:/users database/librarians", n );
            exists =userName.exists();
            
         }
            System.out.println("user name is correct"+"\n===================================");
           long startTime = System.currentTimeMillis();
            
        
            try{
                
                System.out.println("Enter a password for the librarian "+"\""+n+"\"");
                String inPass = in.nextLine();
                Scanner readPassword = new Scanner(new FileInputStream("d:/users database/librarians/"+n));
                String read = readPassword.nextLine();
                readPassword.close();
               
                while(!read.equals(inPass)){
                    System.out.println("Wrong password !! , try again"+"\n===================================");
                    inPass = in.nextLine();
                    
                }
                    
                
                    System.out.println("correct password");
               
                    System.out.println("===================================");
                
                
                
            
            }
            catch(FileNotFoundException e){
                System.out.println("file was not found");
                
            }
      
                //give the librarian  choises:
                System.out.println("==================================="+"\nPress \"1\" to add members "+"\npress \"2\" to add a book category"+"\npress \"3\" to delete or modify a book category" +"\npress \"4\" to add new book"+"\npress \"5\" to delete a book"+"\npress \"6\" toChange the status of a book"+"\n===================================");
                int choises = input.nextInt();
                switch (choises){
                    case 1:
                 System.out.println("Set a new user name");
                 Scanner read = new Scanner(System.in);
        String fileName = read.nextLine();
        
        try{
            File user = new File("d:/users database/members/",fileName);
          
            user.createNewFile();
            System.out.println("a new user name has been set");
        }catch (Exception e ){
            System.out.println("File was not created");
        }
       try{
           System.out.println("Set a password for the user "+fileName);
           String newMemberPassword = read.nextLine();
           PrintWriter writePass = new PrintWriter(new FileOutputStream("d:/users database/members/"+fileName));
           writePass.println(newMemberPassword);
           System.out.println("password has been set for the user "+fileName );
           writePass.close();
           System.out.println("you were logged in for "+(System.currentTimeMillis()-startTime)/1000+" : secondes");
           System.exit(0);
        }
       catch(IOException e){
           System.out.println("password was not written");
       }
                    case 2:
                        System.out.println("add a new category :");
                  
                 Scanner bookInput = new Scanner(System.in);
        String categoryBookName = bookInput.nextLine();
        
        try{
            File user = new File("d:/books database/",categoryBookName);
                      user.mkdirs();
            System.out.println("a new book category has been added");
        }catch (Exception e ){
            System.out.println("File was not created");
        }
        System.out.println("you were logged in for "+(System.currentTimeMillis()-startTime)/1000+" : secondes");
                    System.exit(0);

                    case 3:
                        System.out.println("Enter a book category name :");
                        String inCategoyName = in.nextLine();
                        File categoryFile = new File("d:/books database/",inCategoyName);
                        while (!categoryFile.exists()){
                            System.out.println("The category was not found !! , try again");
                            inCategoyName = in.nextLine();
                            categoryFile = new File("d:/books database/",inCategoyName);
                                                }
                        if(categoryFile.exists()){
                            System.out.println("category has been found"+"\npress 1 to delete the category "+inCategoyName);
                        int choisesCategory = in.nextInt();
                        switch(choisesCategory){
                            case 1:
                                  
                              File fileToDelete = new File("d:/books database/",inCategoyName);
                              File fileIn[]= fileToDelete.listFiles();
                              for(int i=0 ; i<fileIn.length ; i++){
                              fileIn[i].delete();
                              
                              }
                            if(fileToDelete.delete())
                                System.out.println("category was deleted successfully"+"\n===================================");
                            else
                                    System.out.println("Faild to delete the category");
                            
   
                                  System.out.println("you were logged in for "+(System.currentTimeMillis()-startTime)/1000+" : secondes");
                                  System.exit(0);
                          
  
  System.out.println("you were logged in for "+(System.currentTimeMillis()-startTime)/1000+" : secondes");
  System.exit(0);
   
                        }
                   
            
                }
                    case 4 :
                        System.out.println("Enter the book category");
                        Scanner bookAddNew = new Scanner(System.in);
                String inBookCategory = bookAddNew.nextLine();
                
            File user = new File("d:/books database/",inBookCategory);
            while(!user.exists()){
                System.out.println("category was not found .. try again");
                inBookCategory = bookAddNew.nextLine();
                user = new File("d:/books database/",inBookCategory);
            }
        
        try{
            System.out.println("Enter the book name :");
            String inBookName = bookAddNew.nextLine();
                     user = new File(user.getPath(),inBookName);
                     
           
            try{
           
          
           PrintWriter addBook = new PrintWriter(new FileOutputStream(user.getPath()));
           addBook.println("Status : Available");
           addBook.close();
            System.out.println("a new book has been added");
        }
       catch(IOException e){
           System.out.println("Status was not set");
       }
        }catch (Exception e ){
            System.out.println("File was not created");
        }
        System.out.println("you were logged in for "+(System.currentTimeMillis()-startTime)/1000+" : secondes");
                    System.exit(0);
                        
                        
                        
                    case 5:
                        System.out.println("Enter the book category name :");
                        String bookCategory = in.nextLine();
                        File searchBookCategory = new File("d:/books database/" ,bookCategory );
                        while (!searchBookCategory.exists()){
                            System.out.println("The category was not found !! , try again");
                           bookCategory = in.nextLine();
                            searchBookCategory = new File("d:/books database/" ,bookCategory );
                                                }
                        
                            System.out.println("category was found : "+"\nEnter the book name :");
                            
                            String bookName = in.nextLine();
                            File searchBookName = new File(searchBookCategory.getPath(),bookName );
                            while(!searchBookName.exists()){
                                System.out.println("book was not found !! , try again..");
                                bookName = in.nextLine();
                                searchBookName = new File(searchBookCategory.getPath(),bookName);
                            }
                            System.out.println("the book is found :"+"\npress 1 to delete ");
                            int modifyBookDelete = in.nextInt();
                            switch(modifyBookDelete){
                                case 1:
                                   
                                    
                                     
   File fileToDelete = new File(searchBookCategory.getPath());
   File fileToDeleteList []=fileToDelete.listFiles();
   for(int i=0 ; i<fileToDeleteList.length;i++){
   fileToDeleteList[i].delete();
   }
   if(fileToDelete.delete())
                                        System.out.println("The book is deleted");
   else
                                        System.out.println("The book is not deleted");
   
    
                              case 2:
                                  Scanner inputLibrarian = new Scanner(System.in);
                                  System.out.println("Enter the new book name");
                                   String newFileNameIn = inputLibrarian.nextLine();
                                  
                                   
       
                         System.out.println("=============================================");
                        System.out.println("you were logged in for "+(System.currentTimeMillis()-startTime)/1000+" : secondes");
                        System.out.println("=============================================");
System.exit(0);

                            } 
                           
                            
                            
                            
                            
                    case 6:
                        System.out.println("Enter the book category :");
                        String editStatus1 = in.nextLine();
                        File editStatusCategory = new File("d:/books database",editStatus1);
                        while(!editStatusCategory.exists()){
                            System.out.println("book category was not found !! try again :");
                            editStatus1 = in.nextLine();
                         editStatusCategory = new File("d:/books database",editStatus1);}
                            System.out.println("Enter the book name :");
                             String editStatus2 = in.nextLine();
                             File editStatusBook = new File(editStatusCategory,editStatus2);
                             while(!editStatusBook.exists()){
                                 System.out.println("the book was not found !! try again :");
                             editStatus2 = in.nextLine();
                             editStatusBook = new File(editStatusCategory,editStatus2);
                             }
                             
                             System.out.println("press \"1\" to change to Available or \"2\" to borrowed");
                             int bookStatusChange = in.nextInt();
                             while(bookStatusChange>2 &&bookStatusChange<1){
                                 System.out.println("please enter 1 or 2");
                                 bookStatusChange = in.nextInt();
                             
                             }
                             if(bookStatusChange == 1){
                              try{
           
          
           PrintWriter changeBookStatus = new PrintWriter(editStatusBook.getPath());
           changeBookStatus.println("Status : Available");
           changeBookStatus.close();
            System.out.println("the book "+editStatus2+" is available now");
        }
                              catch(IOException e){
                                  System.out.println("was not modified");
                              }
                             
                             
                             
                             
                             }
                             else if(bookStatusChange == 2){
                             
                              try{
           
          
           PrintWriter changeBookStatus = new PrintWriter(editStatusBook.getPath());
           changeBookStatus.println("Status : Borrowed");
           changeBookStatus.close();
                                  System.out.println(editStatus2);
            System.out.println("the book "+editStatus2+" is Borrowed now");
        }
                              catch(IOException e){
                                  System.out.println("was not modified");
                              }
                             
                             
                             
                         System.out.println("=============================================");
                        System.out.println("you were logged in for "+(System.currentTimeMillis()-startTime)/1000+" : secondes");
                        System.out.println("=============================================");
                            
                             }
                            }
                 System.exit(0);
                        }
                
                
           
                else if(logIn==3){
      Scanner memberInput = new Scanner(System.in);
        System.out.println("Enter a member user name :");
        String memberUserName = memberInput.nextLine();
        File readMemberUserName =new File("d:/users database/members" , memberUserName );
        boolean memberUserNameExists =readMemberUserName.exists();
        while(!memberUserNameExists){
            System.out.println("user name wrong !! , try again");
             memberUserName = memberInput.nextLine();
         readMemberUserName =new File("d:/users database/members" , memberUserName );
        memberUserNameExists =readMemberUserName.exists();
        }
                    System.out.println("correct member user name");
            try{
                System.out.println("Enter a password");
                String inPass = memberInput.nextLine();
                Scanner readPassword = new Scanner(new FileInputStream("d:/users database/members/"+memberUserName));
                String read = readPassword.nextLine();
                readPassword.close();
                while(!read.equals(inPass)){
                    System.out.println("wrong member password !!, try again");
                    inPass = memberInput.nextLine();
                }
                    System.out.println("correct member password");
                
            
            }
            catch(FileNotFoundException e){
                System.out.println("file was not found");
               
            }
         System.out.println("press \"1\" to update your profile"+"\npress \"2\" to search for a book"+"\npress \"3\" to Borrow a book");
         
         int memberChoises = input.nextInt();
         while(memberChoises>3 ||memberChoises<1){
             System.out.println("wrong choise , please enter 1 , 2 , 3");
              memberChoises = input.nextInt();}
              
              
              if(memberChoises ==1){
                  System.out.println("Enter \"1\" to change the user name or \"2\" to change the password ");
                  int updateProfile =input.nextInt();
                  while(updateProfile>2 ||updateProfile<1){
                      System.out.println("Wrong choise , please enter 1 , 2");
                      updateProfile =input.nextInt();
                  } Scanner inUser = new Scanner(System.in);
                  if(updateProfile == 1){
                     
                       System.out.println("Enter your old user name :");
                      String oldMemberName = inUser.nextLine();
                  File memberNameToupdated = new File("d:/users database/members",oldMemberName);
                  File memberNameToupdated2 = new File("d:/users database/members",memberUserName);
                  while(!(memberNameToupdated2.equals(memberNameToupdated)&&memberNameToupdated.exists())){
                      System.out.println("Try again , Enter your previous user name :");
                           oldMemberName = inUser.nextLine();
                           memberNameToupdated = new File("d:/users database/members",oldMemberName);
                           memberNameToupdated2 = new File("d:/users database/members",memberUserName);
                  }
                     if(memberNameToupdated2.equals(memberNameToupdated)&&memberNameToupdated.exists()){
                         System.out.println("Enter your new user name :");
                         String newFileNameIn = inUser.nextLine();
                          File newFileName = new File("d:/users database/members",newFileNameIn);
  try {
   if (memberNameToupdated2.renameTo(newFileName)) {
    System.out.println("your name was modified successfully !");
   } else {
    System.out.println("user name was not modified !");
   }

  } catch (Exception e) {
   e.printStackTrace();
  }
                         
                         
                                  
                     }
                  
                  }
                  else if(updateProfile==2){
                      System.out.println("ENter your user name :");
                      String changePassword = inUser.nextLine();
                  File toChangePassword = new File("d:/users database/members",changePassword);
                  while(!(toChangePassword.exists()&& toChangePassword.equals(readMemberUserName))){
                      System.out.println("try again , Enter your user name :");
                    changePassword = inUser.nextLine();
                  toChangePassword = new File("d:/users database/members",changePassword);
                  
                  
                  }
                      try{
                          PrintWriter newPassword = new PrintWriter(new FileOutputStream(toChangePassword.getPath()));
                          System.out.println("Enter your new Password :");
                          String newEnterPassword = inUser.nextLine();
                          newPassword.println(newEnterPassword);
                          newPassword.close();
                          System.out.println("you changed your password to :"+newEnterPassword);
                  }catch(IOException e){
                          System.out.println("Password was not modified !!");
                  }
              }
                  System.exit(0);
         }
              
              else if(memberChoises == 2){
              Scanner inUser = new Scanner(System.in);
                  System.out.println("Enter the book category you want to search in :");
                  String searchForBook = inUser.nextLine();
                  File searchForAbook =new File("d:/books database/",searchForBook);
                          while(!searchForAbook.exists()){
                          System.out.println("The category was not found .. try again! :");
                   searchForBook = inUser.nextLine();
                   searchForAbook =new File("d:/books database/",searchForBook);
                                                         }
                          System.out.println("Enter the book name :");
                          String inBookSearch =inUser.nextLine();
                          File searchForBookname = new File(searchForAbook.getPath(),inBookSearch);
                          while(!searchForBookname.exists()){
                          System.out.println("the book was not found , re-enter the book name :");
                           inBookSearch =inUser.nextLine();
                          searchForBookname = new File(searchForAbook.getPath(),inBookSearch);

                          }
                          System.out.println("The book "+inBookSearch+" is found " );
                          
              
              }
              else if(memberChoises == 3){
                  Scanner inUser = new Scanner(System.in);
                  System.out.println("Enter the category :");
                  String borrowBook = inUser.nextLine();
                  File borrowBookFile = new File("d:/books database/",borrowBook);
                  while(!borrowBookFile.exists()){
                   System.out.println("The category was not found !! RE-Enter the category :");
                   borrowBook = inUser.nextLine();
                  borrowBookFile = new File("d:/books database/",borrowBook);
                  
                  
                  }
                  System.out.println("Enter the book name :");
                  String borrowBookName = inUser.nextLine();
               File borrowBookFileName = new File(borrowBookFile.getPath(),borrowBookName);
               while(!borrowBookFileName.exists()){
               System.out.println("The book was not found ,RE-Enter the book name :");
                   borrowBookName = inUser.nextLine();
               borrowBookFileName = new File(borrowBookFile.getPath(),borrowBookName);
               
               }
                  
                  try{
                  Scanner checkBorrowBook = new Scanner(new FileInputStream(borrowBookFileName.getPath()));
                  String readFromBook =checkBorrowBook.nextLine();
                   checkBorrowBook.close();
                   if(readFromBook.equalsIgnoreCase("Status : Available")){
                       System.out.println("The book is available : press \"1\" to borrow");
                         int borrow = inUser.nextInt();
                         
                         try{
                         PrintWriter changeBookStatus = new PrintWriter(new FileOutputStream(borrowBookFileName.getPath()));
                         changeBookStatus.println("Status : Borrowed");
                         changeBookStatus.close();
                         
                         
                         }catch(IOException e){
                             System.out.println("Book status was not changed");
                         }
                          System.out.println("you borrowed the book ");
                   }
                   else
                          System.out.println("Sorry : the book is already borrowed");
                   
                  }catch(IOException e){
                      System.out.println("problem with reading book status :");
                      System.exit(0);
                  }
                        }
                        }
                
        }
    }

       
              
              
                       
             

