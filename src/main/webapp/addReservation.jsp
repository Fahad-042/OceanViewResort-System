<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Reservation</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body style="background: linear-gradient(135deg,#4e73df,#1cc88a);">

<div class="container mt-5">
    <div class="card shadow-lg p-4">
        <h2 class="text-center text-primary mb-4">Add New Reservation</h2>

        <form action="addReservation" method="post">

            <div class="mb-3">
                <label class="form-label">Guest Name</label>
                <input type="text" name="guest_name" class="form-control" required minlength="3">
            </div>

            <div class="mb-3">
                <label class="form-label">Address</label>
                <input type="text" name="address" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Contact Number</label>
                <input type="text" name="contact_number"
                       class="form-control"
                       pattern="[0-9]{10}"
                       title="Contact number must be exactly 10 digits"
                       required>
            </div>

            <div class="mb-3">
                <label class="form-label">Room Type</label>
                <select name="room_type" class="form-select">
                    <option value="Single">Single</option>
                    <option value="Double">Double</option>
                    <option value="Suite">Suite</option>
                </select>
            </div>

            <div class="mb-3">
                <label class="form-label">Check-in Date</label>
                <input type="date" name="check_in" class="form-control" required>
            </div>

            <div class="mb-3">
                <label class="form-label">Check-out Date</label>
                <input type="date" name="check_out" class="form-control" required>
            </div>

            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-success btn-lg">
                    Add Reservation
                </button>
            </div>

        </form>

        <div class="text-center mt-3">
            <a href="dashboard.jsp" class="btn btn-secondary">
                Back to Dashboard
            </a>
        </div>

    </div>
</div>

</body>
</html>