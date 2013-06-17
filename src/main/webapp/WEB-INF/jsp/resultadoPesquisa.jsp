
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
background:rgb(190,190,190)  repeat-x 50% 0%;
color:white !important;
font-family:"Courier New";
font-size:12px;
}
</style>

<div id="header" style="background-color:#C0C0C0; height: 375px; width: 676px">
 
<h1 style="margin-bottom:0;">
<h2 id="header_1" class="form-header">Listar Receitas
</h2>     

</h1><div id="content" style="background-color:#EEEEEE;height: 296px;width: 677px;float:left;"><li class="form-line" id="id_4">
<form></form><c:forEach var="receita" items="${receitas}">
<a href="/receitas/${receita.externalId}">
<p>Titulo:&nbsp;${receita.titulo}&nbsp;&nbsp;
<a href="receitas/${ receita.externalId}/delete">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Apagar</a>
<a href="editarReceita/${receita.externalId}/">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Editar</a>
</p>


 

</a>
</c:forEach>
</li><br><br><br><br><br>
<input type="button" value="Voltar" color="#505050" onclick="javascript:history.go(-1)">

</div>

<div id="footer" style="background-color:#C0C0C0;clear:both;text-align:center;">
trabalho de grupo ULHT COOKBOOK-ES</div>