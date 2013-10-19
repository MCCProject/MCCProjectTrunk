<!DOCTYPE html>
<html>
<head>
  <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
  <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
  <title>Look Around o-O</title>
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1"/>
  
  <!-- CSS -->
  <link rel="stylesheet" href="css/jquery.mobile-1.3.0.min.css" />
  <link rel="stylesheet" href="css/client.css" />  
  <!-- Javascript -->
  <script src="js/jquery-1.9.1.min.js"></script>
  <script src="js/jquery.mobile-1.3.0.min.js"></script>
  <script src="js/jquery.zweatherfeed.min.js" type="text/javascript"></script>

</head>

<body>
  <!-- Main Container Page -->
  <div data-role="page" data-theme="a" id="i_containerPage">
    <!-- Main Header -->
    <div data-role="header" id="i_hdr" data-nobackbtn="true" data-theme="e">
      <div align="center">
        <h1 id="main_logo"><u>Look Around o-O</u></h1>
        <div class="smallHdr">Your City: Kansas City, MO</div>
      </div>
    </div> <!-- End Main Header -->

    <!-- Main Content -->
    <div data-role="content" id="i_content" data-theme="e">
      <div id="weather" class="ui-body ui-body-b" align="center" style="margin:0 auto">      
      </div>
      <div id="restaurants" class="ui-body ui-body-b">
        <h4>Restaurants cuisines near you.</h4>
        <ul data-role="listview" data-inset="true" data-filter="true">
          <li><a href="choose_restaurant.html" data-transition="slidedown"><img src="css/images/class.jpg"/><h3>American</h3><span class="ui-li-count" >8</span></a></li>
          <li><a href="choose_restaurant.html" data-transition="slidedown"><img src="css/images/burger.jpg"/><h3>Bar and Grill</h3><span class="ui-li-count" >4</span></a></li>
          <li><a href="choose_restaurant.html" data-transition="slidedown"><img src="css/images/pizza.jpg"/><h3>Pizza</h3><span class="ui-li-count" >3</span></a></li>
          <li><a href="choose_restaurant.html" data-transition="slidedown"><img src="css/images/kebab.jpg"/><h3>Middle Eastern</h3><span class="ui-li-count" >3</span></a></li>
          <li><a href="choose_restaurant.html" data-transition="slidedown"><img src="css/images/sushi.jpg"/><h3>Sushi</h3><span class="ui-li-count" >2</span></a></li>
        </ul>    
      </div>
    </div> <!-- End Main Content -->
    
    <!-- Main Footer -->
    <div data-role="footer" id="i_ftr" data-theme="c">
      <p align="center">&copy; 2013 Team Look Around</p>
      <p align="center"><img src="css/images/logo.jpg"/></p>      
    </div> <!-- End Main Footer -->
  </div> <!-- End Main Container Page -->

  <!-- Progress Container Page -->
  <div data-role="page" data-theme="d" data-nobackbtn="true" id="i_containerProgressPage">
      <div align="center"><h4>Please wait...</h4></div>
      <div align="center"><img id="spin" src="css/images/ajax-loader.gif"/></div>
 </div> <!-- End Progress Container Page -->

  <script type="text/javascript">
      
    // Commonly Used Variables
    var m_i_hdr;
    var m_i_content;
    var m_i_ftrMain;
    var m_i_progressPage;

    $(document).ready(function () {
      m_i_hdr = $('#i_hdr');
      m_i_content = $('#i_content');
      m_i_ftrMain = $('#i_ftr');
      m_i_progressPage = $('#i_containerProgressPage');
    });


    $(document).ready(function () {
      $('#weather').weatherfeed(['USMO0460'], {
         unit: 'f',
         link: false
      });
    });  
    
    function hideMain() {
      m_i_hdr.hide();
      m_i_content.hide();
      m_i_ftrMain.hide();
    }

    function hideProgress() {
      m_i_progressPage.hide();
    }

    function showProgress() {
      hideMain();
      m_i_progressPage.show();
    }
    
    function loadPage(url) {
      showProgress();
      Android.loadPage(url);
    }
    
  </script>
  
</body>
</html>
