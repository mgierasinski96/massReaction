<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="mgierasinski.domain.Point" %>
<%@ page import="java.util.List" %>
<%

//        String nameH = "";
//        String nameW = "";
//        String nameS = "";
//        try {
//            nameH = (String) request.getParameter("field1");
//            nameW = (String) request.getParameter("paramW");
//            nameS = (String) request.getParameter("paramS");
//        } catch (Exception ex) {
//        }
//        long loggedUserId = (long) request.getAttribute("userId");
//        double wisdomCalc = (double) request.getAttribute("wisdomCalc");
//        double strengthCalc = (double) request.getAttribute("strengthCalc");
//        String userProfession = (String) request.getAttribute("userProfession");
//        double healthCalc = (double) request.getAttribute("healthCalc");
//        long userGold = (long) request.getAttribute("userGold");
//        List<Point> pointList = (List<Point>) request.getAttribute("pointList");
    try{


           String healthCalc = (String) request.getAttribute("domain");
       int userGold = (int) request.getAttribute("id");
        System.out.println("z inputa"+healthCalc);
        System.out.println("z inputa"+userGold);
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
    }



//
//        Connection con = null;
//        java.sql.Statement s = null;
//        java.sql.ResultSet rs = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/massReaction_tracker?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "hbstudent", "hbstudent");
//
//        } catch (ClassNotFoundException cnfex) {
//            cnfex.printStackTrace();
//        }
//        String query = "";
//        if (nameH != null) {
//            System.out.println("health");
//            int increasedValue = Integer.parseInt(nameH) + 1;
//            double userTotalHealth = increasedValue * healthCalc;
//            long newUserGold = userGold - (pointList.get(increasedValue - 2).getPointCost());
//            query = "update usercharacter set userHP='" + increasedValue + "',userTotalHp='" + userTotalHealth + "',userGold='" + newUserGold + "' where userId=" + loggedUserId + " ";
//
//        } else if (nameW != null) {
//            System.out.println("wisdom");
//            int increasedValue = Integer.parseInt(nameW) + 1;
//            double userWisdomCalc = increasedValue * wisdomCalc;
//            long newUserGold = userGold - (pointList.get(increasedValue - 2).getPointCost());
//            if (userProfession.toLowerCase().equals("czarodziej"))
//                query = "update usercharacter set userWisdom='" + increasedValue + "',userTotalDmg='" + userWisdomCalc + "',userGold='" + newUserGold + "' where userId=" + loggedUserId + " ";
//            else
//                query = "update usercharacter set userWisdom='" + increasedValue + "',userTotalDodge='" + userWisdomCalc + "',userGold='" + newUserGold + "' where userId=" + loggedUserId + " ";
//
//        } else {
//            System.out.println("strength");
//            int increasedValue = Integer.parseInt(nameS) + 1;
//            double userStrengthCalc = increasedValue * strengthCalc;
//            long newUserGold = userGold - (pointList.get(increasedValue - 2).getPointCost());
//
//            if (userProfession.toLowerCase().equals("czarodziej"))
//                query = "update usercharacter set userStrength='" + increasedValue + "',userTotalDodge='" + userStrengthCalc + "',userGold='" + newUserGold + "' where userId=" + loggedUserId + " ";
//            else
//                query = "update usercharacter set userStrength='" + increasedValue + "',userTotalDmg='" + userStrengthCalc + "',userGold='" + newUserGold + "' where userId=" + loggedUserId + " ";
//        }
//        try { //try1start
//            s = con.createStatement();
//            int count = s.executeUpdate(query);
//            if (count > 0) {
//            }
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        } finally { //close
//            if (rs != null) rs.close();
//            if (s != null) s.close();
//            if (con != null) con.close();
//        }

%>








