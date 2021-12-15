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

  const jobListComponent = ['year', 'locat'];
  return (
    <>
      <div class="jobListDisplay">
        <ListGroup as="ol" numbered>
          {jobListComponent}
        </ListGroup>
      </div>
    </>
  );
}
