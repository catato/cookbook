<!DOCTYPE html>
<html>
<body>

<div id="container" style="width:800px">

<div id="header" style="background-color:#C0C0C0;">
 
<h1 style="margin-bottom:0;">COOKBOOK  <form method="get" action="http://www.google.com/"> 
<table cellpadding="0px" cellspacing="0px"> 
<tr> 
<td style="border-style:solid none solid solid;border-color:#4B7B9F;border-width:1px;">
 
</td>
</td>
</tr>
</table>
</form>   

</h1>
   
   </div>

<div id="menu" style="background-color:#C0C0C0;height:400px;width:150px;float:left;">

<a href="/criar">Criar Receita</a>
</br>
<a href="/ListarReceita">Listar Receita</a>
</br>

 

</div>

<div id="content" style="background-color:#EEEEEE;height:400px;width:650px;float:left;">

 <form method = "POST" action="receita/pesquisa">
   
   <input type ="text" name="campoPesquisar"/>  <input type ="submit" value="Pesquisar"/>    
 </form>
 </br>
 <input type="button" value="Voltar" color="#505050" onclick="javascript:history.go(-1)">
 
</div>

<div id="footer" style="background-color:#C0C0C0;clear:both;text-align:center;">
trabalho de grupo ULHT COOKBOOK-ES</div>

</div>

</body>
</html>