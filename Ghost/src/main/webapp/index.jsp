
 
             <% if (request.isUserInRole("test")) { %>
<frameset cols="200,*">
    <frame src="menu.jsp"     name="menu" noresize/>
    <frame src="contents.jsp" name="contents"/>
</frameset>


 <% } else
                    {%>
                      <h3>Unauth Admin</h3>
                   <% } %>