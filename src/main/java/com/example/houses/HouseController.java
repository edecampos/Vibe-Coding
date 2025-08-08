package com.example.houses;

import com.example.houses.model.House;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
public class HouseController {

    private final HouseService houseService;

    public HouseController(HouseService houseService) {
        this.houseService = houseService;
    }

    @GetMapping(value = "/cheapest", produces = MediaType.TEXT_HTML_VALUE)
    public String getCheapestHousesAsTable(
            @RequestParam(defaultValue = "5926 MARSH CIRCLE LOVELAND OH 45140") String address,
            @RequestParam(defaultValue = "100") int radius
    ) {
        List<House> houses = houseService.getTop10CheapestPerSqFt(address, radius);

        StringBuilder sb = new StringBuilder();
        sb.append("<html><head><title>Cheapest Houses</title>");
        sb.append("<style>body{font-family:sans-serif;}table{border-collapse:collapse;}th,td{border:1px solid #ccc;padding:4px 8px;}th{background:#f0f0f0;}a{color:#1a73e8;}</style>");
        sb.append("</head><body>");
        sb.append("<h2>Top 10 Cheapest Houses per Sq Ft</h2>");
        sb.append("<table>");
        sb.append("<tr>");
        sb.append("<th>Address</th>");
        sb.append("<th>Price</th>");
        sb.append("<th>Sq. Ft.</th>");
        sb.append("<th>$ / Sq.Ft.</th>");
        sb.append("</tr>");
        for (House h : houses) {
            sb.append("<tr>");
            sb.append("<td>").append(h.getAddress() != null ? h.getAddress() : "").append("</td>");
            sb.append("<td>").append(h.getPrice() != null ? String.format("$%,.2f", h.getPrice()) : "").append("</td>");
            sb.append("<td>").append(h.getSquareFootage() != null ? h.getSquareFootage().intValue() : "").append("</td>");
            sb.append("<td>").append(h.getCostPerSquareFoot() != null ? String.format("$%.2f", h.getCostPerSquareFoot()) : "").append("</td>");
            sb.append("</tr>");
        }
        sb.append("</table>");
        sb.append("</body></html>");
        return sb.toString();
    }

    // New home page endpoint!
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        return "<html>" +
                "<head><title>Welcome to Vibe Coding Project 2025!</title>" +
                "<style>" +
                "body{font-family:sans-serif;background:linear-gradient(135deg,#e0c3fc 0%,#8ec5fc 100%);padding:2em;text-align:center;}" +
                "h1{font-size:2.5em;color:#333;margin-bottom:0.5em;}" +
                "p{font-size:1.2em;color:#444;}" +
                "a{display:inline-block;margin:1em 0;padding:0.75em 1.5em;border-radius:8px;background:#5e60ce;color:#fff;text-decoration:none;font-weight:bold;font-size:1.1em;transition:background 0.2s;}" +
                "a:hover{background:#3f37c9;}" +
                ".emoji{font-size:2em;}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='emoji'>🏠✨</div>" +
                "<h1>Welcome to Vibe Coding Project 2025!</h1>" +
                "<p>Ready to explore real estate like never before?<br>Click the button below to view the <strong>Cheapest Houses</strong> app:</p>" +
                "<a href='https://cts-vibeappce21201-4.azurewebsites.net/api/houses/cheapest' target='_blank'>🏠 Launch Cheapest Houses App</a>" +
                "<p>Want to see the source code or contribute?<br>Visit our GitHub repo:</p>" +
                "<a href='https://github.com/edecampos/Vibe-Coding' target='_blank'>💻 Vibe Coding GitHub Repo</a>" +
                "<p style='margin-top:2em;color:#6a4c93;'>Made with ❤️ for the 2025 Coding Challenge!</p>" +
                "</body></html>";
    }
}