
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/declarativemethods.jspf" %>
<%@page import="edu.nbcc.student.Student"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dev Teams</title>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <style>
            .container{
                padding:20px;
            }
            .student-select{
                width:275px;
            }

            .blue{
                color:blue;
            }
        </style>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/navigation.jspf" %>
        <h1>All Dev Teams</h1>
        <div class="container">
            <%
            	if (request.getParameter("btnClear") != null) {
            		session.removeAttribute("teams");
            	}
            	
            	List<List<Student>> studentTeams = new ArrayList();
            	if (session.getAttribute("teams") != null) {
					studentTeams = (List<List<Student>>)session.getAttribute("teams");					
				}
            %>
            <% 
            	if (studentTeams.size() > 0) { 
            		int teamNo = 1;
            	
            %>
            <table class="table table-striped">
                <tr>
                    <th>
                        Team Number
                    </th>
                    <th>
                        First Name
                    </th>
                    <th>
                        Last Name
                    </th>
                </tr>
			<% 
				for (List<Student> t: studentTeams) { 
					for (Student s: t) {
			%>
               <tr>
                    <th>
                        <%= teamNo %>
                    </th>
                    <th>
                        <%= s.getFirstName() %>
                    </th>
                    <th>
                        <%= s.getLastName() %>
                    </th>
                </tr>
               <%}}} else { %>
               <h2>No teams</h2>
               <%} %>
            </table>
            <form method="post">
                <button class="btn btn-primary" name="btnClear">Clear Teams</button>                
            </form>
            
        </div>

        <%@include file="WEB-INF/jspf/footer.jspf" %>
    </body>
</html>