<%@ page import="java.sql.*, java.util.ArrayList, java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Medicine Dashboard</title>
    <style>
        /* Basic styling */
        .medicine-card {
            display: inline-block;
            width: calc(33.33% - 20px);
            margin: 10px;
            background-color: #f9f9f9;
            padding: 20px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            box-sizing: border-box;
            vertical-align: top;
        }
        .medicine-img {
            width: 100%;
            max-width: 200px;
            height: auto;
            display: block;
            margin: 0 auto 10px;
        }
        .medicine-title {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Medicine Dashboard</h1>
        <% 
            List<Medicine> medicines = fetchMedicineDetails();
            for (Medicine medicine : medicines) {
        %>
            <div class="medicine-card">
                <img src="<%= medicine.getImage() %>" alt="<%= medicine.getName() %>" class="medicine-img">
                <div class="medicine-title"><%= medicine.getName() %></div>
            </div>
        <% } %>
    </div>
</body>
</html>

<%
    // Method to fetch medicine details from the database
    List<Medicine> fetchMedicineDetails() {
        List<Medicine> medicines = new ArrayList<>();

        try {
            // JDBC URL, username, and password of MySQL server
            String JDBC_URL = "jdbc:mysql://localhost:3306/elite";
            String USERNAME = "root";
            String PASSWORD = "";

            // Load MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish connection to the database
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // SQL query to fetch medicine details
            String query = "SELECT name, image FROM medicine";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through the result set and create Medicine objects
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String image = resultSet.getString("image");
                medicines.add(new Medicine(name, image));
            }

            // Close connections
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return medicines;
    }
%>

<%
    // Medicine class to hold medicine details
    public static class Medicine {
        private String name;
        private String image;

        public Medicine(String name, String image) {
            this.name = name;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public String getImage() {
            return image;
        }
    }
%>
