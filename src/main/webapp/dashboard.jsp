<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ocean View Resort Dashboard</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #ffffff, #fbfffc);
            min-height: 100vh;
        }

        .dashboard-card {
            margin-top: 80px;
            padding: 40px;
            border-radius: 15px;
            background: white;
            box-shadow: 0px 10px 30px rgba(0,0,0,0.2);
        }

        .dashboard-title {
            font-weight: bold;
            color: #2e59d9;
        }

        .btn-custom {
            padding: 15px;
            font-size: 18px;
            border-radius: 10px;
        }
    </style>
</head>

<body>

<div class="container">
    <div class="dashboard-card text-center">

        <h2 class="dashboard-title mb-4">
            Ocean View Resort Admin Dashboard
        </h2>

        <p class="mb-4 text-muted">
            Manage reservations, calculate bills and control the system securely.
        </p>

        <div class="d-grid gap-2">

            <a href="addReservation.jsp" class="btn btn-success btn-lg">
                 Add New Reservation
            </a>

            <a href="viewReservations" class="btn btn-primary btn-lg">
                 View Reservations
            </a>

            <a href="help.jsp" class="btn btn-secondary btn-lg">
                 Help Section
            </a>

            <a href="logout" class="btn btn-danger btn-lg">
                 Logout
            </a>

        </div>

    </div>
</div>

</body>
</html>