# Link Shortener

A simple URL shortener application built using Spring Boot and Elasticsearch.

## Features

- Shorten long URLs into compact links
- Redirect to the original URL when accessing the shortened link
- Store and retrieve shortened URLs efficiently using Elasticsearch
- User-friendly API for creating and managing shortened links

## Technologies Used

- **Spring Boot**: Framework for building the application
- **Elasticsearch**: Search engine for storing and retrieving URL data
- **Maven**: Dependency management and build tool

## Getting Started

### Endpoints

| Method | Endpoint |Description | Request Body | Response |
| --- | --- | --- | --- | --- |
| Post |```/shortLink```| Shortens a long URL | ``` "urlPlain":"http://google.co12" ``` | Shortened URL with unique value |
| Post |```/url/{uniqueValue}``` | Shortens a long URL | Pass unique value as PathVariable | Redirect to original URL |


![pic](https://github.com/user-attachments/assets/e0ea9a43-e725-4c19-98cf-fd737eac2723)
**The test connection I created by redirecting with Ngrok ended up being ironically long.**


### Prerequisites

- Java 11 or higher
- Maven
- Elasticsearch (version 8.x or compatible)

### Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/root14/link-shorter.git
   cd link-shorter
