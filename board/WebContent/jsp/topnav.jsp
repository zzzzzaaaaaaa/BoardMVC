<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title></title>
    <style media="screen">
      *{ box-sizing: border-box;}
      html, body{
        margin: 0;
      }
      .topnav{
        display: flex;
        background-color: black;
        height: 50px;
        margin: 0;
      }
      .topnav a{
        color: white;
        text-decoration: none;
        padding: 15px;
      }
      .hovMenu{
        display: inline-block;
      }
      .hovMenuList{
        display: none;
        background-color: gray;
      }
      .hovBtn{
        border: none;
        background-color: black;
        height: 50px;
        color: white;
      }
      .hovMenu:hover .hovMenuList{
        display: grid;
      }
      .topnav a:hover{
        background-color: red;
      }


    </style>
  </head>
  <body>
    <nav class="topnav">
      <a href="#">1</a>
      <a href="#">2</a>
      <a href="boardList?num=1&category=0">3</a>      
      <div class="hovMenu">
        <button type="button" class="hovBtn" name="button">hahaha</button>
        <div class="hovMenuList">
          <a href="boardList?num=1&category=1">11</a>
          <a href="boardList?num=1&category=2">22</a>
          <a href="boardList?num=1&category=3">33</a>
        </div>
      </div>
    </nav>
  </body>
</html>
