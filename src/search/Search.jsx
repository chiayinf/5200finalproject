import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import Form from "react-bootstrap/Form";
import ListGroup from "react-bootstrap/ListGroup";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";


export default function Search() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const term = urlParams.get("term");
    console.log("t", term);
    const [allReports, setAllReports] = useState([]);
    function findAllReports() {
      /* axios
        .get("http://localhost:8000/api/jobs/" + term)
        .then((response) => {
          setAllJobs(response.data);
        })
        .catch((error) => console.error(error)); */
    }
    useEffect(findAllReports, []);
    if (allReports.length === 0) {
        return (
          <>
            <Container>
              <h1> No Report found with key word: {term}</h1>
            </Container>
          </>
        );
      }



}