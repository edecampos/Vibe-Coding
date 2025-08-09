package com.example.houses;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        return "<html>" +
            "<head><title>Welcome to Vibe Coding Project 2025!</title>" +
            "<style>" +
            "body{font-family:sans-serif;background:linear-gradient(135deg,#e0c3fc 0%,#8ec5fc 100%);padding:2em;text-align:center;}" +
            "h1{font-size:2.5em;color:#333;margin-bottom:0.5em;}" +
            "p{font-size:1.2em;color:#444;}" +
            ".logo{margin-bottom:2em;}" +
            ".emoji{font-size:2em;}" +
            ".step{display:none;max-width:500px;margin:2em auto;padding:2em;background:#fff;border-radius:12px;box-shadow:0 2px 10px #ccc;text-align:left;}" +
            ".step.active{display:block;}" +
            "label{display:block;margin:1em 0 0.3em 0;font-weight:bold;}" +
            "input[type=text], input[type=number]{width:96%;padding:0.5em;margin-bottom:1em;border:1px solid #ccc;border-radius:6px;}" +
            "button{background:#5e60ce;color:#fff;padding:0.8em 2em;border:none;border-radius:8px;font-size:1.1em;font-weight:bold;cursor:pointer;transition:background 0.2s;}" +
            "button:hover{background:#3f37c9;}" +
            "#resultsFrame{width:100%;max-width:900px;height:600px;border:none;box-shadow:0 2px 10px #ccc;margin:2em auto;display:none;}" +
            ".required-message{color:#c92a2a;font-weight:bold;margin-bottom:1em;}" +
            "</style>" +
            "<script>" +
            "function showStep(step) {" +
            "  document.getElementById('step1').classList.remove('active');" +
            "  document.getElementById('step2').classList.remove('active');" +
            "  document.getElementById('step3').classList.remove('active');" +
            "  document.getElementById('step'+step).classList.add('active');" +
            "}" +
            "function nextStep1() {" +
            "  var address = document.getElementById('address').value.trim();" +
            "  if(address === '') {" +
            "    alert('Please enter Address, State, Zip Code'); return;" +
            "  }" +
            "  showStep(2);" +
            "}" +
            "function nextStep2() {" +
            "  var radius = document.getElementById('radius').value.trim();" +
            "  if(radius === '' || isNaN(radius) || radius <= 0) {" +
            "    alert('Please enter a valid radius'); return;" +
            "  }" +
            "  showStep(3);" +
            "  document.getElementById('summaryAddress').innerText = document.getElementById('address').value;" +
            "  document.getElementById('summaryRadius').innerText = document.getElementById('radius').value;" +
            "}" +
            "function submitCheapest() {" +
            "  var address = encodeURIComponent(document.getElementById('address').value);" +
            "  var radius = encodeURIComponent(document.getElementById('radius').value);" +
            "  var iframe = document.getElementById('resultsFrame');" +
            "  iframe.src = '/api/houses/cheapest?address=' + address + '&radius=' + radius;" +
            "  iframe.style.display = 'block';" +
            "}" +
            "window.onload = function() { showStep(1); };" +
            "</script>" +
            "</head>" +
            "<body>" +
            "<div class='logo'><img src='https://upload.wikimedia.org/wikipedia/commons/6/6e/Cognizant_logo.svg' alt='Cognizant' height='60'/></div>" +
            "<div class='emoji'>🏠✨</div>" +
            "<h1>Welcome to Vibe Coding Project 2025!</h1>" +
            "<p class='required-message'>Please note: <strong>Both fields below are mandatory</strong> in order to search for the Top 10 Cheapest Houses per Square Foot.</p>" +
            "<p>Follow the steps below to find the <strong>Cheapest Houses</strong> near you!</p>" +

            // Step 1: Address
            "<div id='step1' class='step active'>" +
            "<label for='address'>Step 1: Enter Address, State, Zip Code <span style='color:#c92a2a'>(required)</span></label>" +
            "<input type='text' id='address' placeholder='123 Main St, City, ST 12345' required />" +
            "<button type='button' onclick='nextStep1()'>Next</button>" +
            "</div>" +

            // Step 2: Radius
            "<div id='step2' class='step'>" +
            "<label for='radius'>Step 2: Enter Radius (miles) <span style='color:#c92a2a'>(required)</span></label>" +
            "<input type='number' id='radius' min='1' max='500' value='100' required />" +
            "<button type='button' onclick='nextStep2()'>Next</button>" +
            "</div>" +

            // Step 3: Summary and Submit
            "<div id='step3' class='step'>" +
            "<h3>Step 3: Review Your Criteria</h3>" +
            "<p><strong>Address:</strong> <span id='summaryAddress'></span></p>" +
            "<p><strong>Radius:</strong> <span id='summaryRadius'></span> miles</p>" +
            "<button type='button' onclick='submitCheapest()'>View Cheapest Houses</button>" +
            "</div>" +

            // Results iframe
            "<iframe id='resultsFrame'></iframe>" +

            "<p style='margin-top:2em;color:#6a4c93;'>Made with ❤️ for the 2025 Coding Challenge!</p>" +
            "<p>Want to see the source code or contribute?<br>Visit our GitHub repo:</p>" +
            "<a href='https://github.com/edecampos/Vibe-Coding' target='_blank' style='background:#222;'>💻 Vibe Coding GitHub Repo</a>" +
            "</body></html>";
    }
}