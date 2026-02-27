<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Reservation</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body style="background: linear-gradient(to right, #36b9cc, #858796);">

<div class="container mt-5">
    <div class="card shadow-lg p-4">

        <h2 class="text-center mb-4">Edit Reservation</h2>

        <form action="editReservation" method="post">

            <input type="hidden" name="id" value="${id}">

            <div class="mb-3">
                <label class="form-label">Guest Name</label>
                <input type="text" name="guest_name" class="form-control" value="${guest_name}">
            </div>

            <div class="mb-3">
                <label class="form-label">Address</label>
                <input type="text" name="address" class="form-control" value="${address}">
            </div>

            <div class="mb-3">
                <label class="form-label">Contact Number</label>
                <input type="text" name="contact_number" class="form-control" value="${contact_number}">
            </div>

            <div class="mb-3">
                <label class="form-label">Room Type</label>
                <input type="text" name="room_type" class="form-control" value="${room_type}">
            </div>

            <div class="mb-3">
                <label class="form-label">Check-in Date</label>
                <input type="date" name="check_in_date" class="form-control" value="${check_in_date}">
            </div>

            <div class="mb-3">
                <label class="form-label">Check-out Date</label>
                <input type="date" name="check_out_date" class="form-control" value="${check_out_date}">
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary px-4">Update</button>
                <a href="viewReservations" class="btn btn-secondary px-4">Back</a>
            </div>

        </form>

    </div>
</div>

</body>
</html>