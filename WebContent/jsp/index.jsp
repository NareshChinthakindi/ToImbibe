<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>ToImbibe</title>
<meta name="keywords" content="Professional Template, HTML, CSS, free website template" />
<meta name="description" content="Professional Template, HTML, CSS, free website template provided by freecsstemplates.in" />
<link href="css/style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

 function loginIntoImbibe(e)
 {
	 if(e.keyCode == 13)
	 {
	  document.toImbibe.submit();
	 }
 }
</script>
</head>
<body>
<div id="header_wrapper">
    <div id="header">
        <div id="site_title_section">
            <div id="site_title">
	          <font face="LUCIDA CONSOLE" size="5">To</font><font size="6" face="FANTASY">Imbibe</font>
            </div>
            <div id="salogon">
	           A way to Learn</div>
            <div class="cleaner">&nbsp;</div>
        </div>
        
        <div id="search_section">
            <form action="#" method="get">
                <input type="text" name="q" size="10" id="searchfield" title="searchfield" />
                <input type="submit" name="Search" value="" alt="Search" id="searchbutton" title="Search" />
            </form>
        </div>    
    </div> <!-- end of header -->
</div>  <!-- end of header wrapper -->


<div id="menu_wrapper">    
    <div id="menu">
        <ul>
            <li><a href="#" class="current"><span></span>Home</a></li>
            <li><a href="http://www.freecsstemplates.in" target="_parent"><span></span>Templates</a></li>
            <li><a href="#"><span></span>Projects</a></li>
            <li><a href="#"><span></span>Partners</a></li>
            <li><a href="#"><span></span>Company</a></li>
            <li><a href="#"><span></span>Contact</a></li>
        </ul>    	
    </div> <!-- end of menu -->
</div> <!-- end of menu wrapper -->

<div id="content_wrapper">
<div id="content">

    <div id="content_left">
        <div class="content_left_section">
            <div class="content_header_01">Our news</div>
            <div class="news_section">
                <div class="news_date">OCT 20, 2048</div>
                <div class="news_title">Nam auctor aliquam leo</div>
                <p>Sed sit amet pretium metus. Nullam bibendum pharetra luctus. Aliquam erat volutpat. Praesent sit amet elementum est. <a href="#">Read more</a></p>
            </div>
        
            <div class="margin_bottom_30"></div>
        
            <div class="news_section">
                <div class="news_date">OCT 19, 2048</div>
                <div class="news_title">Duis ac metus eu nulla pharetra</div>
                <p>Suspendisse dignissim est nec tortor posuere vitae dictum dolor sagittis. Vestibulum at libero velit. Maecenas faucibus ornare erat sed sodales. <a href="#">Read more</a></p>
            </div>
        
            <div class="margin_bottom_20"></div>
            <div class="rc_btn_02"><a href="#">View All</a></div> 
        <div class="cleaner"></div>
        
        </div>   <!-- end of news section -->
        
        <div class="margin_bottom_20 border_bottom"></div>
        <div class="margin_bottom_20"></div>
        
        <div class="content_left_section">
            <div class="content_header_01">Newsletter</div>
            <p>Please enter your email address to subscribe our newsletter</p>
            <form action="#" method="get">
                <input type="text" id="search_field" />
                <input type="submit" value="Subscribe" id="subscribe_button" />
            </form>
            <div class="cleaner"></div>
        </div>
        
        <div class="margin_bottom_20 border_bottom"></div>
        <div class="margin_bottom_20"></div>
        
        <div class="content_left_section">
            <a href="http://validator.w3.org/check?uri=referer"><img style="border:0;width:88px;height:31px" src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
            <a href="http://jigsaw.w3.org/css-validator/check/referer"><img style="border:0;width:88px;height:31px"  src="http://jigsaw.w3.org/css-validator/images/vcss-blue" alt="Valid CSS!" vspace="8" border="0" /></a>
        </div>
    
        <div class="cleaner_h30">&nbsp;</div>
    </div> <!-- end of content left -->

    <div id="content_right">
    
        <div class="content_right_280_section margin_right_60">
            <div class="content_header_01">Welcome to our website</div>
            <div class="image_wrapper"><img src="images/image_01.jpg" alt="image" /></div>
            <p>Professional <a href="http://www.freecsstemplates.in/" target="_parent">website template</a> is provided by <a href="http://www.freecsstemplates.in" target="_parent">freecsstemplates.in</a> for everyone. You may download, modify and apply this layout for your personal or business websites. Credit go to <a href="http://www.photovaco.com" target="_blank">Free Photos</a> for photos. <a href="#">Read more...</a></p>
      </div>
        <div class="content_right_280_section">
       <form name='toImbibe' action="<c:url value='j_spring_security_check' />" method="POST">
            <div class="content_header_01">Login/Registration</div>     
            <p>
                If you have login id and password , you can login to portal by providing your credentials below:
                
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </p> 
            <table>
            <tr>
               <td> Login Id : </td> <td> <input type="text" name="j_username" id="j_username" /></td>
               
            </tr>
            <tr>   
               <td>  Password : </td> <td><input type="password" name="j_password" id="j_password" onkeypress="javascript:loginIntoImbibe(event);"/> </td>
            </tr>
            </table>
            <div class="cleaner"></div>
    
              
            <div class="rc_btn_02">
                  <a href="#" onclick="javascript:document.toImbibe.submit()">Sign In</a>
            </div>
            </form>
            
            <a href="newUserRegisterView.html">Register new user</a>
            
            <div class="cleaner"></div>       
        </div>   
    
        <div class="margin_bottom_40 border_bottom"></div>
        <div class="margin_bottom_40"></div>
    
        <div class="content_right_section">
            <div class="content_header_02">Featured Projects</div>
            
            <div class="content_right_w620_wrapper">
                <div class="content_right_w620_inner">
                    <div class="box_w170 margin_right_25">
                        <div class="image_wrapper"><a href="#"><img src="images/image_03.jpg" alt="image 2" /></a></div>
                        <p>Vestibulum a augue nec dolor vulputate fermentum.</p>
                    </div>
        
                    <div class="box_w170 margin_right_25">
                        <div class="image_wrapper"><a href="#"><img src="images/image_02.jpg" alt="image 3" /></a></div>
                        <p>liquam erat volutpat. Vestibulum neque felis.</p>
                    </div>
    
                    <div class="box_w170">
                        <div class="image_wrapper"><a href="#"><img src="images/image_04.jpg" alt="image 4" /></a></div>
                        <p>Donec nec lectus turpis mauris viverra leo at tortor.</p>
                    </div>
    
                    <div class="margin_bottom_10"></div>
    
                    <div class="rc_btn_02"><a href="#">View all</a></div>
    
                    <div class="cleaner"></div>
                </div>
            </div>
    
    
            <div class="cleaner">&nbsp;</div>
        </div>                    
        <div class="cleaner_h20">&nbsp;</div>
    </div> <!-- end of content right -->

<div class="cleaner">&nbsp;</div>

</div> <!-- end of content -->
</div> <!-- end of content wrapper -->

<jsp:include page="../jsp/includes/imbibeFotter.jspf"/>
</body>
</html>