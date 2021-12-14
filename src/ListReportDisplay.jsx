import React from "react";
import { Link } from "react-router-dom";
import "./style.css";
import Container from "react-bootstrap/Container";
import Form from "react-bootstrap/Form";
import ListGroup from "react-bootstrap/ListGroup";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";

export default function ListReportDisplay(props) {
  const allReports = props.reports;

  const reportListComponent = allReports.map((report) => {
    return (
      <>
        <p></p>
        <ListGroup.Item as="li">
          Year: {report.year}, Location: {report.location}, Type of Crime:
          {report.typeOfCrime}
          <br />
          <Link to={"detail/:" + report._id}>check detail...</Link>
        </ListGroup.Item>
      </>
    );
  });
  return (
    <>
      <div class="reportListDisplay">
        <ListGroup as="ol" numbered>
          {reportListComponent}
        </ListGroup>
      </div>
    </>
  );
}
