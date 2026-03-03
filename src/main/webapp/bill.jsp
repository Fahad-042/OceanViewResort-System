<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Reservation Bill</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>


<body style="background-color: #ffffff;">

<div class="container mt-5">
  <div class="card shadow-lg p-4">

    <h2 class="text-center mb-4">Reservation Bill</h2>

    <ul class="list-group">
      <li class="list-group-item"><strong>Guest Name:</strong> ${guestName}</li>
      <li class="list-group-item"><strong>Room Type:</strong> ${roomType}</li>
      <li class="list-group-item"><strong>Check-in:</strong> ${checkIn}</li>
      <li class="list-group-item"><strong>Check-out:</strong> ${checkOut}</li>
      <li class="list-group-item"><strong>Total Nights:</strong> ${nights}</li>
      <li class="list-group-item"><strong>Rate Per Night:</strong> ${rate}</li>
      <li class="list-group-item list-group-item-success">
        <strong>Total Amount:</strong> ${total}
      </li>
    </ul>

    <div class="text-center mt-4">
      <a href="viewReservations" class="btn btn-dark px-4">Back to Reservations</a>
    </div>

  </div>
</div>



</body>
</html>