<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
        rel="stylesheet" media="screen">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="${R}res/common.js"></script>
  <link rel="stylesheet" href="${R}res/common.css">
</head>
<body>
  <div class="container">
    <h1>도시 목록</h1>
    <hr />

    <c:forEach var="district" items="${ districts }">
      <h3>${ district.districtName } </h3>
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>id</th>
            <th>시 이름</th>
            <th style="text-align: right">인구</th>
            
          </tr>
        </thead>
        <tbody>
          <c:forEach var="city" items="${ district.citys }">
            <tr>
              <td>${ city.id }</td>
              <td>${ city.name }</td>
              <td style="text-align: right">${ city.population }</td>
           
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </c:forEach>
  </div>
</body>
</html>

