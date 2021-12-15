import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import Form from "react-bootstrap/Form";
import ListGroup from "react-bootstrap/ListGroup";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import ListReportDisplay from "../ListReportDisplay";
import Container from "react-bootstrap/Container";
import "../style.css"



export default function Search() {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const term = urlParams.get("term");
    console.log("t", term);
    const [allReports, setAllReports] = useState([]);
    function findAllReports() {
      axios.get("http://45.32.226.189:8080/search/location/"+term, {
        headers: {
          'Access-Control-Allow-Origin': true
        }
        })
        .then((response) => {
          setAllReports(response.data);
        })
        .catch((error) => console.error(error));
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
      const reportListComponent = allReports.map((report) => {
        return (
          <>
            <p></p>
            <Link to={"detail/:" + report._id}>
              {report.year}, {report.location}, {report.typeOfCrime}
            </Link>
          </>
        );
      }); 
      return (
        <>
          <Container>
            <h1> These are all reports with key word: {term}</h1>
            <ListReportDisplay reports={allReports} />
          </Container>
        </>
      );


}