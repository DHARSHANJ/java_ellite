<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pharmacy Dashboard</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
  body {
    background-color: #f8f9fa;
  }
  .container {
    margin-top: 50px;
  }
  input[type="text"], input[type="email"], input[type="tel"], textarea {
    background-color: transparent;
    border: none;
    border-bottom: 1px solid #ced4da;
    border-radius: 0;
  }
  input[type="text"]:focus, input[type="email"]:focus, input[type="tel"]:focus, textarea:focus {
    box-shadow: none;
  }
  .form-control {
    font-weight: bold;
  }
</style>
</head>
<body>
<div class="container">
    <h1 class="text-center">Pharmacy Dashboard</h1>
    <hr>
    <% 
    HttpSession session2 = request.getSession();
    String email = (String) session2.getAttribute("email");
    %>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form>
                <div class="form-group">
                    <label for="clientId">Client ID</label>
                    <input type="text" class="form-control" id="clientId" value="1" readonly>
                </div>
                <div class="form-group">
                    <label for="clientName">Name</label>
                    <input type="text" class="form-control" id="clientName" value="John Doe" readonly>
                </div>
                <div class="form-group">
                    <label for="clientEmail">Email</label>
                    <input type="email" class="form-control" id="clientEmail" value="<%= email %>" readonly>
                </div>
                <div class="form-group">
                    <label for="clientPhone">Phone Number</label>
                    <input type="tel" class="form-control" id="clientPhone" value="123-456-7890" readonly>
                </div>
                <div class="form-group">
                    <label for="clientAddress">Address</label>
                    <textarea type="text" class="form-control" id="clientAddress" rows="3" readonly>123 Main St, City, Country</textarea>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
