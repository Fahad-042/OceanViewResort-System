<%@ page import="java.util.List" %>
<%@ page import="com.example.oceanviewresort.model.Reservation" %>

<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <title>View Reservations</title>
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
            <th>Address</th>
            <th>Check-in</th>
            <th>Check-out</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Reservation> reservations =
                    (List<Reservation>) request.getAttribute("reservations");

            if (reservations != null) {
                for (Reservation r : reservations) {
        %>
        <tr>
            <td><%= r.getId() %></td>
            <td><%= r.getGuestName() %></td>
            <td><%= r.getContact() %></td>
            <td><%= r.getRoomType() %></td>
            <td><%= r.getAddress() %></td>
            <td><%= r.getCheckInDate() %></td>
            <td><%= r.getCheckOutDate() %></td>
            <td>
                <a class="btn btn-sm btn-primary"
                   href="editReservation?id=<%= r.getId() %>">
                    Edit
                </a>

                <a class="btn btn-sm btn-danger"
                   href="deleteReservation?id=<%= r.getId() %>">
                    Delete
                </a>

                <a class="btn btn-sm btn-success"
                   href="bill?id=<%= r.getId() %>">
                    Bill
                </a>
            </td>
        </tr>
        <%
                }
            }
        %>

        </tbody>
    </table>

    <a href="dashboard.jsp" class="btn btn-secondary mt-3">
        Back to Dashboard
    </a>

</div>
</body>
</html>