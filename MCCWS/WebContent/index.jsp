<!DOCTYPE html>
<html>
<head>
  <META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
  <META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
  <title>Look Around o-O</title>
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1"/>
  
  <!-- CSS -->
  <link rel="stylesheet" href="css/jquery.mobile-1.3.2.min.css" />
  <link rel="stylesheet" href="css/client.css" />  
  <!-- Javascript -->
  <script src="js/jquery-1.9.1.min.js"></script>
  <script src="js/jquery.mobile-1.3.2.min.js"></script>
  <script src="js/jquery.zweatherfeed.min.js" type="text/javascript"></script>

</head>

<body>
  <!-- Main Container Page -->
  <div id="i_containerPage" data-role="page" data-theme="a">
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
      <p><a id=refresh href="#i_containerPage" data-icon="refresh" data-role="button">Refresh</a></p>   
      <div id="restaurants" class="ui-body ui-body-b">
        <h4>Restaurants cuisines near you.</h4>
        <ul id="typeList" data-role="listview" data-inset="true" data-filter="true">
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

  <div id="i_choose_restaurant" data-role="page" data-add-back-btn="true">
   
    <div data-role="header" data-theme="e"> 
      <h1>Choose Restaurant</h1>
    </div> 

    <div data-role="content">
    
    <div class="choice_list"> 
    <h1>Pick a place to eat!</h1>
    
    <ul id="restList" data-role="listview" data-inset="true" data-filter="true">                       
    </ul>
    </div>
    
    </div>   
   
  </div><!-- /page -->

  <div id="i_restaurant" data-role="page" data-add-back-btn="true">
   
    <div data-role="header" data-theme="e">
      <h1>Restaurant Details</h1>
    </div> 
   
    <div data-role="content">
    <div class="ui-grid-a" id="restaurant_info">
      <div class="ui-block-a">
        <h2 id=name></h1>
        <p><strong>Fine <span id=cuisine></span>.</strong></p>
        <h3>Rating: <span id=rating></span></h3>
      </div>
      <div class="ui-block-b">
        <h2>Distance: <span id=distance></span> miles.</h2>
        <p><a id=website href="http://www.google.com" rel="external" target="blank" data-role="button">Visit Our Website</a></p>
      </div>
    </div><!-- /grid-a -->
    <hr/>
   
    <div class="ui-grid-b" id="contact_infos">
      <div class="ui-block-a">
      <h2>Contact Info</h2>
      <h5 id=address></h5>
      </div>
    </div><!-- /grid-b -->
    <div id="contact_buttons">      
      <a id=map href="http://maps.google.com/maps" target="blank" data-role="button" data-icon="maps">Find us on Google Maps </a>
      <a id=phone href="tel:8167531840"  data-role="button" data-icon="tel">Call us</a>
    </div>
    <hr/>
   
    <div data-role="fieldcontain">
        <fieldset data-role="controlgroup">
          <legend>Travel Mode:</legend>
              <input type="radio" name="radio-choice-1" id="radio-choice-1" value="Driving" checked="checked" />
              <label for="radio-choice-1">Driving</label>

              <input type="radio" name="radio-choice-1" id="radio-choice-2" value="Walking"  />
              <label for="radio-choice-2">Walking</label>

              <input type="radio" name="radio-choice-1" id="radio-choice-3" value="Bicycling"  />
              <label for="radio-choice-3">Bicycling</label>

              <input type="radio" name="radio-choice-1" id="radio-choice-4" value="Transit"  />
              <label for="radio-choice-4">Transit</label>
        </fieldset>
    </div>
   
  </div><!-- /page -->  

  <script type="text/javascript">

    // Commonly used variables
    var selectedTypeIdx = 0;
    var selectedRestIdx = 0;
    var position;

    $(document).ready(function () {
      $('#weather').weatherfeed(['USMO0460'], {
         unit: 'f',
         link: false
      });
            
      getGeoLocation();
      position = JSON.parse(localStorage.getItem("location"));
      var restURI = "http://vhost1628.site1.compute.ihost.com:18080/MCCWS/jaxrs/mccservices/currentPath/" + position.latitude + "," + position.longitude;
      callService(restURI, position, processResponse);
    });

    $('#refresh').on('click', function () {
      location.reload(true);
    });

    $('#typeList').on('click', ' > li', function () {
      var selIdx = $(this).index();
      selectedTypeIdx = selIdx;
    });
    
    // Call a service URI and return JSONP to a function
    function callService(uri, position, successFunction) {
        $.ajax({
            cache: true,
            url: uri,
            data: position,
            type: "GET",
            contentType: "application/javascript",
            dataType: "jsonp",
            error: ajaxCallFailed,
            failure: ajaxCallFailed,
            success: successFunction
        });          
    }
     
    // Called if ajax call fails
    function ajaxCallFailed(jqXHR, textStatus) { 
        console.log("Error: " + textStatus);
        console.log(jqXHR);
        alert("Sorry, there was an error.");
    }

    function getGeoLocation()
    {
      if (navigator.geolocation)
      {
        navigator.geolocation.getCurrentPosition(getLocation, showError);
      }
      else
      {
        x.innerHTML="Geolocation is not supported by this browser.";
      }
    }

    function getLocation(position)
    {
      var location = 
      { 
        "latitude" : position.coords.latitude,
        "longitude" : position.coords.longitude
      };

      localStorage.setItem("location", JSON.stringify(location));

      return position;
    }    
    
    function processResponse(response) {
      localStorage.setItem("response", response["result:"]);
      var responseObj = $.parseJSON(response["result:"]);
      console.log(response);

      $.each(responseObj, function(key, value) {
        if (key != null && value != null)
        {
          $('ul#typeList').append('<li><a href="#i_choose_restaurant" data-transition="slidedown"><img src="' + getPic(value.Cusine) + '"/><h3>' + value.Cusine + '</h3><span class="ui-li-count" >' + value.NumOfLocations + '</span></a></li>');             
        }
      });

      $('ul#typeList').listview('refresh');         
    }

    function showError(error)
    {
      switch(error.code) 
      {
        case error.PERMISSION_DENIED:
          alert("User denied the request for Geolocation.");
          break;
        case error.POSITION_UNAVAILABLE:
          alert("Location information is unavailable.");
          break;
        case error.TIMEOUT:
          alert("The request to get user location timed out.");
          break;
        case error.UNKNOWN_ERROR:
          alert(x.innerHTML="An unknown error occurred.");
          break;
      }
    }

    function getPic(type)
    {
      type = type.toUpperCase();
      var image = 'css/images/class.jpg';
      switch (type)
      {
        case 'AMERICAN':
          image = 'css/images/american.jpg'
          break;
        case 'AMERICAN (NEW)':
          image = 'css/images/american.jpg'
          break;          
        case 'BURGERS':
          image = 'css/images/american.jpg'
          break;
        case 'FAST FOOD':
          image = 'css/images/american.jpg'
          break;                      
        case 'CHINESE':
          image = 'css/images/chinese.jpg'
          break;
        case 'MEDITERRANEAN':
          image = 'css/images/mideast.jpg'
          break;
        case 'EGYPTIAN':
          image = 'css/images/mideast.jpg'
          break;
        case 'ETHNIC FOOD':
          image = 'css/images/mideast.jpg'
          break;
        case 'MIDDLE EASTERN':
          image = 'css/images/mideast.jpg'
          break;          
        case 'PAKISTANI':
          image = 'css/images/mideast.jpg'
          break;                              
        case 'PIZZA':
          image = 'css/images/pizza.jpg'
          break;
        case 'FRENCH':
          image = 'css/images/french.jpg'
          break;
        case 'ICE CREAM':
          image = 'css/images/icecream.jpg'
          break;
        case 'DESSERTS':
          image = 'css/images/icecream.jpg'
          break;          
        case 'BARS':
          image = 'css/images/bar.jpg'
          break;
        case 'BEER, WINE & SPIRITS':
          image = 'css/images/wine.jpg'
          break;
        case 'BREWERIES':
          image = 'css/images/bar.jpg'
          break;                    
        case 'PUBS':
          image = 'css/images/bar.jpg'
          break;
        case 'GASTROPUBS':
          image = 'css/images/bar.jpg'
          break;        
        case 'HOME DECOR':
          image = 'css/images/home.jpg'
          break;
        case 'HOOKAH BARS':
          image = 'css/images/hookah.jpg'
          break;
        case 'LOUNGES':
          image = 'css/images/hookah.jpg'
          break;           
        case 'INDIAN':
          image = 'css/images/indian.jpg'
          break;                                     
        case 'FOOD DELIVERY SERVICES':
          image = 'css/images/delivery.jpg'
          break;            
        case 'BUFFETS':
          image = 'css/images/buffet.jpg'
          break;
        case 'CAFES':
          image = 'css/images/cafe.jpg'
          break;                        
        case 'MEXICAN':
          image = 'css/images/mexican.jpg'
          break;
        case 'SUSHI':
          image = 'css/images/sushi.jpg'
          break;
        case 'JAPANESE':
          image = 'css/images/sushi.jpg'
          break;
        case 'THAI':
          image = 'css/images/thai.jpg'
          break;                    
        case 'GERMAN':
          image = 'css/images/german.jpg'
          break;
        case 'VEGAN':
          image = 'css/images/vegan.jpg'
          break;
        case 'VEGETARIAN':
          image = 'css/images/vegan.jpg'
          break;          
        case 'SEAFOOD':
          image = 'css/images/seafood.jpg'
          break;   
       case 'ITALIAN':
          image = 'css/images/italian.jpg'
          break;  
       case 'BARBEQUE':
          image = 'css/images/bbq.jpg'
          break;
       case 'SANDWICHES':
          image = 'css/images/sandwich.jpg'
          break;  
       case 'BAKERIES':
          image = 'css/images/bakery.jpg'
          break;  
       case 'SMOOTHIES':
          image = 'css/images/smoothie.jpg'
          break;
       case 'BREAKFAST & BRUNCH':
          image = 'css/images/breakfast.jpg'
          break;
       case 'BREAKFAST':
          image = 'css/images/breakfast.jpg'
          break;            
       case 'WINE BARS':
          image = 'css/images/wine.jpg'
          break;                   
        default:
          image = 'css/images/french.jpg'
          break;   
      }

      return image;
    }

    function getSelectedTypeIdx()
    {
      return selectedTypeIdx;
    }

    function getSelectedRestIdx()
    {
      return selectedRestIdx;
    }    

    $('#i_choose_restaurant').on('pagebeforeshow', function (event) {      
      var response = getResponse();
      processRestaurants(response);
    });

    $('#restList').on('click', ' > li', function () {
      var selIdx = $(this).index();
      selectedRestIdx = selIdx;
    });

    function getResponse()
    {
      return JSON.parse(localStorage.getItem("response"));
    }
    
    function processRestaurants(response) {
      console.log(response);
      $('ul#restList').empty();
      $.each(response[getSelectedTypeIdx()].Locations, function(key, value) {
        if (key != null && value != null)
        {
          $('ul#restList').append('<li><a href="#i_restaurant" data-transition="slidedown">' + value.Name + '</a></li>');
        }
      });

      $('ul#restList').listview('refresh');         
    }

    $('#i_restaurant').on('pagebeforeshow', function (event) {
      var response = getResponse();
      processDetails(response);
    });
    
    function processDetails(response) {
      var type = response[getSelectedTypeIdx()];
      if (type != null) {
        $('#cuisine').text(type.Cusine);
        var restaurant = type.Locations[getSelectedRestIdx()];
        if (restaurant != null) {
          $('#name').text(restaurant.Name);
          $('#rating').text(restaurant.Rating);
          var distance = restaurant.Distance.toFixed(2);
          $('#distance').text(distance);
          $('#address').text(restaurant.Address.replace(/\[|\]/g, ''));
          $('#map').attr('href', 'http://maps.google.com/maps?saddr=' + position.latitude + ',' + position.longitude + '&daddr=' + restaurant.Name + '&sensor=false' + '&dirflg=' + $('input[name*=radio-choice-]:checked').val());
          $('#phone').attr('href', 'tel:' + restaurant.URL);
          $('#website').attr('href', restaurant.Cusine);
        }
      }       
    }    
    
  </script>
  
</body>
</html>
