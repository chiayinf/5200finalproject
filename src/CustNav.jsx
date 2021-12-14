import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { Navbar, Nav, Container, Button } from "react-bootstrap";

export default function CustNav() {
  return (
    <>
      <Navbar bg="light" expand="lg">
        <Container>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav>
              <Navbar.Brand href="/">Seattle Crime Dashboard</Navbar.Brand>
              {/* <Nav.Link href="/search">Search Report</Nav.Link> */}
              <Nav.Link href="/demo">Demo Charts</Nav.Link>
              <Nav.Link href="/create">Create New Report</Nav.Link>
            </Nav>
            
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </>
  );
  /* return (
    <>
      <div>

        <Navbar bg="light" expand="lg">
          <Container>
            <Navbar.Brand href="#home">Seattle Crime Dashboard</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
              <Nav className="me-auto">
                <Nav.Link href="#home">Home Page</Nav.Link>
                <Nav.Link href="/search">Search Report</Nav.Link>                
                <Nav.Link href="/demo">Demo Charts</Nav.Link>
                <Nav.Link href="/create">Create New Report</Nav.Link>
              </Nav>
              
            </Navbar.Collapse>
          </Container>
        </Navbar>
      </div>
    </>
  ) */
}
