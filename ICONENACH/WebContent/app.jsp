
<%@page import="java.util.Map"%>
<%@page import="com.intech.lem.service.ApplicationDetails"%>

<html>
<head>

<title>LEM</title>


<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<!------ Include the above in your HEAD tag ---------->
<!--   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 -->  
<!--   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script> -->
  

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>


<link rel="stylesheet" href="/resources/demos/style.css">
<script src="script/sript.js"></script>


<link rel="stylesheet"  href="css/idbi_flex.css"><link>

<link rel="stylesheet"  href="css/main.css"><link>
<style>
@import url(https://fonts.googleapis.com/css?family=Libre+Baskerville);
* {
  box-sizing: border-box;
  border-radius: 5px;
}

body {
  font-family: 'Libre Baskerville';
}

.heading-primary {
  font-size: 2em;
  padding: 2em;
  text-align: center;
}

.accordion dl,
.accordion-list {
  border: 1px solid #ddd;
}

.accordion dl:after,
.accordion-list:after {
  content: "";
  display: block;
  height: 1em;
  width: 100%;
  background-color: #099DF6;
}

.accordion dd,
.accordion__panel {
  background-color: #eee;
  font-size: 1em;
  line-height: 1.5em;
}

.accordion p {
  padding: 1em 2em 1em 2em;
}

.accordion {
  position: relative;
  background-color: #eee;
}

.container {
  max-width: 960px;
  margin: 0 auto;
  padding: 2em 0 2em 0;
}

.accordionTitle,
.accordion__Heading {
  background-color: #099DF6;
  /*text-align: center; */
  
  text-indent: 3px;
  font-weight: 700;
  padding: 2em;
  display: block;
  text-decoration: none;
  color: #fff;
  -webkit-transition: background-color 0.5s ease-in-out;
  transition: background-color 0.5s ease-in-out;
  border-bottom: 1px solid #30bb64;
}

.accordionTitle:before,
.accordion__Heading:before {
  content: "+";
  font-size: 1.5em;
  line-height: 0.9em;
  float: left;
  -webkit-transition: -webkit-transform 0.3s ease-in-out;
  transition: transform 0.3s ease-in-out;
}

.accordionTitle:hover,
.accordion__Heading:hover {
  background-color: #38CC70;
}

.accordionTitleActive,
.accordionTitle.is-expanded {
  background-color: #38CC70;
}

.accordionTitleActive:before,
.accordionTitle.is-expanded:before {
  -webkit-transform: rotate(-225deg);
  -ms-transform: rotate(-225deg);
  transform: rotate(-225deg);
}

.accordionItem {
  height: auto;
  overflow: auto;
  max-height: 900px;
  -webkit-transition: max-height 1s;
  transition: max-height 1s;
}

@media screen and (min-width: 48em) {
  .accordionItem {
    max-height: 900px;
    -webkit-transition: max-height 0.5s;
    transition: max-height 0.5s;
  }
}

.accordionItem.is-collapsed {
  max-height: 0;
}

.no-js .accordionItem.is-collapsed {
  max-height: 900px;
}

.animateIn {
  -webkit-animation: accordionIn 0.65s normal ease-in-out both 1;
  animation: accordionIn 0.65s normal ease-in-out both 1;
}

.animateOut {
  -webkit-animation: accordionOut 0.75s alternate ease-in-out both 1;
  animation: accordionOut 0.75s alternate ease-in-out both 1;
}

@-webkit-keyframes accordionIn {
  0% {
    opacity: 0;
    -webkit-transform: scale(0.9) rotateX(-60deg);
    transform: scale(0.9) rotateX(-60deg);
    -webkit-transform-origin: 50% 0;
    transform-origin: 50% 0;
  }
  100% {
    opacity: 1;
    -webkit-transform: scale(1);
    transform: scale(1);
  }
}

@keyframes accordionIn {
  0% {
    opacity: 0;
    -webkit-transform: scale(0.9) rotateX(-60deg);
    transform: scale(0.9) rotateX(-60deg);
    -webkit-transform-origin: 50% 0;
    transform-origin: 50% 0;
  }
  100% {
    opacity: 1;
    -webkit-transform: scale(1);
    transform: scale(1);
  }
}

@-webkit-keyframes accordionOut {
  0% {
    opacity: 1;
    -webkit-transform: scale(1);
    transform: scale(1);
  }
  100% {
    opacity: 0;
    -webkit-transform: scale(0.9) rotateX(-60deg);
    transform: scale(0.9) rotateX(-60deg);
  }
}

@keyframes accordionOut {
  0% {
    opacity: 1;
    -webkit-transform: scale(1);
    transform: scale(1);
  }
  100% {
    opacity: 0;
    -webkit-transform: scale(0.9) rotateX(-60deg);
    transform: scale(0.9) rotateX(-60deg);
  }
}
/*label styles */

.label-style {
  float: left;
  margin-right: 15px;
  padding-top: 5px;
  padding-left: 100px;
}
/* form headings */

.headings {
  text-align: center;
  font-weight: bold;
}
/* button styles */

.button-container {
  text-align: center;
  margin-bottom: 5px;
}
/* position of the hint */

.hint {
  display: inline-block;
  position: relative;
  margin-left: 0.5em;
  margin-top: 0.3em;
}
/* background style for 'i' */

.hint-icon {
  background: #099DF6;
  border-radius: 10px;
  cursor: pointer;
  display: inline-block;
  font-style: normal;
  font-family: 'Libre Baskerville';
  height: 20px;
  line-height: 1.3em;
  text-align: center;
  width: 20px;
}
/* hint icon hover style */

.hint-icon:hover {
  background: #1f8ac9;
}
/* Displays the hint. important! Do not remove. */

.hint:hover .hint-description,
.hint:focus .hint-description {
  display: inline-block;
}
/* position of the hint  */

.hint-description {
  display: none;
  background: #3b3b3b;
  border: 1px solid #099DF6;
  border-radius: 3px;
  font-size: 0.8em;
  color: #ffffff;
  font-weight: bold;
  /*padding: 1em; */
  
  position: absolute;
  left: 30px;
  top: -15px;
  width: 180px;
  height: auto;
}
/* styling for the arrow */

.hint-description:before,
.hint-description:after {
  content: "";
  position: absolute;
  left: -11px;
  top: 15px;
  border-style: solid;
  border-width: 10px 10px 10px 0;
  border-color: transparent #099DF6;
}
/* overlay styling */

.hint-description:after {
  left: -10px;
  border-right-color: #3b3b3b;
}
</style>

</head>

 <body>
 
 <div id="idbi_flex">
    <div id="top_div_part1" ><a href="#"><img src="images/logo/idbi-bank-top.gif" alt="Home" width="229" height="45" border="0"></a></div>
 </div>
 
 <div id="idbi_flex_below">
    <div id="top_div_part_below" ></div>
 </div>
 <!-- Used some part of the code from Chris Wright (https://codepen.io/chriswrightdesign/)'s Pen  -->
<div class="container">
  <h1 class="heading-primary">Accordion Checkout Form Version 0.1 </h1>
  <div class="accordion">
    <dl>
      <!-- description list -->

      <dt>
          <!-- accordion tab 1 - Delivery and Pickup Options -->
          <a href="#accordion1" aria-expanded="false" aria-controls="accordion1" class="accordion-title accordionTitle js-accordionTrigger">Delivery and Pickup Options</a>
        </dt>
      <dd class="accordion-content accordionItem is-collapsed" id="accordion1" aria-hidden="true">
        <p>One can insert a div here and add the product image and the description of the product. Quantity, Cost.</p>
      </dd>
      <!--end accordion tab 1 -->

      <dt>
          <!-- accordion tab 2 - Shipping Info -->
          <a href="#accordion2" aria-expanded="false" aria-controls="accordion2" class="accordion-title accordionTitle js-accordionTrigger">Shipping Information</a>
        </dt>
      <dd class="accordion-content accordionItem is-collapsed" id="accordion2" aria-hidden="true">
        <div class="container-fluid" style="padding-top: 20px;">
          <p class="headings">Shipping Address</p>
          <form class="main-container">
            <div class="row">
              <div class="col-xs-4">
                <label for="fullname" class="label-style">Full Name</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="fullname" class="form-control" placeholder="Enter your full name" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Enter your full name</p>
              </div>
            </div>


            <div class="row">
              <div class="col-xs-4">
                <label for="companyname" class="label-style">Company Name</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="companyname" class="form-control" placeholder="Enter Company Name (optional)" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Enter your Company name</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="phonenumber" class="label-style">Phone Number</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="phonenumber" class="form-control" placeholder="Enter Phone Number" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">In (555)5555-555 Format</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="address-line1" class="label-style">Address Line 1</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="address-line1" class="form-control" placeholder="Enter Address" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Address Line 1</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="address-line2" class="label-style">Line 2</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="address-line2" class="form-control" placeholder="Apt, Suite, Bldg (optional)" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Address Line 2</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="city" class="label-style">City</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="city" class="form-control" placeholder="Enter City" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Enter your City</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="state" class="label-style">State</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="state" class="form-control" placeholder="Enter State" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Ex: Indiana as IN</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="country" class="label-style">Country</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="country" class="form-control" placeholder="Enter Country" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Enter your country</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="zipcode" class="label-style">Zip Code</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="zipcode" class="form-control" placeholder="Enter Zip Code" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Enter ZipCode.</p>
              </div>
            </div>
            <div class="button-container">
              <button class="btn btn-success" type="submit">Submit</button>
              <button class="btn btn-warning" type="reset">Reset</button>
            </div>
          </form>
        </div>
      </dd>
      <!-- end accordion tab 2 -->

      <dt>
          <!-- accordion tab 3 - Payment Info -->
          <a href="#accordion3" aria-expanded="false" aria-controls="accordion3" class="accordion-title accordionTitle js-accordionTrigger">Payment Information</a>
        </dt>
      <dd class="accordion-content accordionItem is-collapsed" id="accordion3" aria-hidden="true">
        <div class="container-fluid" style="padding-top: 20px;">
          <p class="headings">Billing Information</p>
          <form class="main-container">
            <div class="row">
              <div class="col-xs-4">
                <label for="fullname" class="label-style">Full Name</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="fullname" class="form-control" placeholder="Enter your full name" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Enter your full name</p>
              </div>
            </div>


            <div class="row">
              <div class="col-xs-4">
                <label for="companyname" class="label-style">Company Name</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="companyname" class="form-control" placeholder="Enter Company Name (optional)" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Enter your Company name</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="phonenumber" class="label-style">Phone Number</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="phonenumber" class="form-control" placeholder="Enter Phone Number" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">In (555)5555-555 Format</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="address-line1" class="label-style">Address Line 1</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="address-line1" class="form-control" placeholder="Enter Address" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Address Line 1</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="address-line2" class="label-style">Line 2</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="address-line2" class="form-control" placeholder="Apt, Suite, Bldg (optional)" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Address Line 2</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="city" class="label-style">City</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="city" class="form-control" placeholder="Enter City" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Enter your City</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="state" class="label-style">State</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="state" class="form-control" placeholder="Enter State" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Ex: Indiana as IN</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="country" class="label-style">Country</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="country" class="form-control" placeholder="Enter Country" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Enter your country</p>
              </div>
            </div>
            <div class="row">
              <div class="col-xs-4">
                <label for="zipcode" class="label-style">Zip Code</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="address-line2" class="form-control" placeholder="Enter Zip Code" required>
              </div>
              <div class="hint">
                <i class="hint-icon">i</i>
                <p class="hint-description">Enter ZipCode.</p>
              </div>
            </div>
            <div class="button-container">
              <button class="btn btn-success" type="submit">Submit</button>
              <button class="btn btn-warning" type="reset">Reset</button>
            </div>
          </form>
        </div>
      </dd>
      <!-- end accordion tab 3 -->

    </dl>
    <!-- end description list -->
  </div>
  <!-- end accordion -->
</div>
<!-- end container -->
<script id="rendered-js">
//uses classList, setAttribute, and querySelectorAll
//if you want this to work in IE8/9 youll need to polyfill these
(function () {
  var d = document,
  accordionToggles = d.querySelectorAll('.js-accordionTrigger'),
  setAria,
  setAccordionAria,
  switchAccordion,
  touchSupported = ('ontouchstart' in window),
  pointerSupported = ('pointerdown' in window);

  skipClickDelay = function (e) {
    e.preventDefault();
    e.target.click();
  };

  setAriaAttr = function (el, ariaType, newProperty) {
    el.setAttribute(ariaType, newProperty);
  };
  setAccordionAria = function (el1, el2, expanded) {
    switch (expanded) {
      case "true":
        setAriaAttr(el1, 'aria-expanded', 'true');
        setAriaAttr(el2, 'aria-hidden', 'false');
        break;
      case "false":
        setAriaAttr(el1, 'aria-expanded', 'false');
        setAriaAttr(el2, 'aria-hidden', 'true');
        break;
      default:
        break;}

  };
  //function
  switchAccordion = function (e) {
    e.preventDefault();
    var thisAnswer = e.target.parentNode.nextElementSibling;
    var thisQuestion = e.target;
    if (thisAnswer.classList.contains('is-collapsed')) {
      setAccordionAria(thisQuestion, thisAnswer, 'true');
    } else {
      setAccordionAria(thisQuestion, thisAnswer, 'false');
    }
    thisQuestion.classList.toggle('is-collapsed');
    thisQuestion.classList.toggle('is-expanded');
    thisAnswer.classList.toggle('is-collapsed');
    thisAnswer.classList.toggle('is-expanded');

    thisAnswer.classList.toggle('animateIn');
  };
  for (var i = 0, len = accordionToggles.length; i < len; i++) {if (window.CP.shouldStopExecution(0)) break;
    if (touchSupported) {
      accordionToggles[i].addEventListener('touchstart', skipClickDelay, false);
    }
    if (pointerSupported) {
      accordionToggles[i].addEventListener('pointerdown', skipClickDelay, false);
    }
    accordionToggles[i].addEventListener('click', switchAccordion, false);
  }window.CP.exitedLoop(0);
})();
//# sourceURL=pen.js
    </script>
</body>
</html>