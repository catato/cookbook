<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://www.jotform.com/min/g=jotform&3.1.92" type="text/javascript"></script>
<script type="text/javascript">

JotForm.init();
</script>
<link type="text/css" rel="stylesheet" href="http://www.jotform.com/css/styles/form.css?v3.1.92"/>
<link type="text/css" rel="stylesheet" href="http://www.jotform.com/css/styles/industrial_dark.css" />
<link href="http://www.jotform.com/css/calendarview.css?v3.1.92" rel="stylesheet" type="text/css" />
<style type="text/css">

.form-label{
width:150px !important;
}
.form-label-left{
width:150px !important;
}
.form-line{
padding:10px;
}
.form-label-right{
width:150px !important;
}
.form-all{
width:650px;
background:rgb(190,190,190) url(http://www.jotform.com/images/styles/style4_2_bg.gif) repeat-x 50% 0%;
color:black !important;
font-family:"Courier New";
font-size:12px;
}
</style>



<div id="header" style="background-color:#C0C0C0; height: 375px; width: 660px">
<h1 style="margin-bottom:0;">
<h2 id="header_1" class="form-header">Detalhes Receitas
</h2>     

</h1>
<div id="content" style="background-color:#EEEEEE;height:400px;width: 661px;float:left;">
  
<p>Titulo:   ${receita.titulo}</p>
<p>Problema: ${receita.problema}</p>
<p>Autor:    ${receita.autor}</p>
<p>Solução:  ${receita.solucao}</p>
<p> Criado às: ${receita.creationTimestamp}<br><br><br><br><br><br><br>
<input type="button" value="Voltar" color="#505050" onclick="javascript:history.go(-1)"></p>


</div>





<div id="footer" style="background-color:#C0C0C0;clear:both;text-align:center; width: 661px; height: 24px">
trabalho de grupo ULHT COOKBOOK-ES</div>

</div>

