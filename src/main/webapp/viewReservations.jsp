<%@ page import="java.sql.*" %>
<%@ page import="com.oceanview.util.DBConnection" %>

<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>View Reservations</title>
    <th>Action</th>
</head>

<%
    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>
<body>
<div class="container mt-4">

    <h2 class="mb-4">All Reservations</h2>

    <table class="table table-striped table-bordered table-hover shadow">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Guest Name</th>
            <th>Contact</th>
            <th>Room Type</th>
            <th>Check-in</th>
            <th>Check-out</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>

    <%
        ResultSet rs = (ResultSet) request.getAttribute("reservations");
        while (rs.next()) {
    %>
    <tr>
        <td><%= rs.getInt("reservation_id") %></td>
        <td><%= rs.getString("guest_name") %></td>
        <td><%= rs.getString("contact_number") %></td>
        <td><%= rs.getString("room_type") %></td>
        <td><%= rs.getDate("check_in_date") %></td>
        <td><%= rs.getDate("check_out_date") %></td>
        <td>
            <a class="btn btn-sm btn-primary"
               href="editReservation?id=<%= rs.getInt("reservation_id") %>">
                Edit
            </a>

            <a class="btn btn-sm btn-danger"
               href="deleteReservation?id=<%= rs.getInt("reservation_id") %>">
                Delete
            </a>

            <a class="btn btn-sm btn-success"
               href="bill?id=<%= rs.getInt("reservation_id") %>">
                Bill
            </a>
        </td>
    </tr>
    <%
        }
    %>
</table>

</div>

<br>

<a href="dashboard.jsp" class="btn btn-secondary mt-3">
    Back to Dashboard
</a>

</body>
</html>
