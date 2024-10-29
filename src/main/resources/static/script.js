async function shortenUrl() {
    const urlInput = document.getElementById("urlInput").value;
    const resultDiv = document.getElementById("result");

    try {
        const baseUrl = "https://2da8-2a02-ff0-3323-e087-c23-dea4-9093-b234.ngrok-free.app";
        const response = await fetch(`${baseUrl}/shortLink`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Accept": "text/plain"
            },
            body: JSON.stringify({urlPlain: urlInput}),
        });

        if (response.status === 200 || response.status === 302) {
            const shortUrlPath = await response.text();
            resultDiv.innerHTML = `<p>Shortened URL: <a href="${shortUrlPath}" target="_blank">${shortUrlPath}</a></p>`;
        } else if (response.status === 406) {
            resultDiv.innerHTML = "<p>Incorrectly formatted URL. Use \"http://\" or \"https://\" format.</p>";
        } else {
            resultDiv.innerHTML = "<p>Failed to shorten URL. Please try again.</p>";
        }
    } catch (error) {
        resultDiv.innerHTML = "<p>Error: Unable to connect to the server.</p>";
    }
}
