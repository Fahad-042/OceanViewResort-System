<%@ page import="com.example.oceanviewresort.model.Reservation" %>

<%
    Reservation reservation =
            (Reservation) request.getAttribute("reservation");

    if (reservation == null) {
%>
<h3 style="color:red; text-align:center;">Reservation not found</h3>
<%
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Reservation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body style="background-color: #ffffff;">

<div class="container mt-5">
    <div class="card shadow p-4">
        <h2 class="text-center mb-4">Edit Reservation</h2>

        <% if (request.getAttribute("error") != null) { %>
        <div class="alert alert-danger">
            <%= request.getAttribute("error") %>
        </div>
        <% } %>

        <form action="editReservation" method="post">

            <input type="hidden" name="id" value="<%= reservation.getId() %>">

            <div class="mb-3">
                <label>Guest Name</label>
                <input type="text" name="guest_name"
                       class="form-control"
                       value="<%= reservation.getGuestName() %>" required>
            </div>

            <div class="mb-3">
                <label>Address</label>
                <input type="text" name="address"
                       class="form-control"
                       value="<%= reservation.getAddress() %>" required>
            </div>

            <div class="mb-3">
                <label>Contact Number</label>
                <input type="text"
                       name="contact"
                       class="form-control"
                       value="<%= reservation.getContact() %>"
                       pattern="[0-9]{10}"
                       title="Contact number must be exactly 10 digits"
                       required>
            </div>

            <div class="mb-3">
                <label>Room Type</label>
                <input type="text" name="room_type"
                       class="form-control"
                       value="<%= reservation.getRoomType() %>" required>
            </div>

            <div class="mb-3">
                <label>Check-in Date</label>
                <input type="date" name="check_in_date"
                       class="form-control"
                       value="<%= reservation.getCheckInDate() %>" required>
            </div>

            <div class="mb-3">
                <label>Check-out Date</label>
                <input type="date" name="check_out_date"
                       class="form-control"
                       value="<%= reservation.getCheckOutDate() %>" required>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary">Update</button>
                <a href="viewReservations" class="btn btn-secondary">Back</a>
            </div>

        </form>
    </div>
</div>

</body>
</html>