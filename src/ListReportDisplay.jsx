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
  console.log('the type of allReports is ', typeof allReports);
  console.log('all reports', allReports.data);
  console.log('a report', allReports.data[0]);
  // const reportListComponent = [];
  /* for (let report of allReports.data){
    reportListComponent.push(report);
  }
  console.log('5 reports', reportListComponent); */

  /* for (let i = 0; i < 5; i++) {
    reportListComponent.push(allReports.data[i]);
  }
  console.log('5 reports', reportListComponent); */
  const reportListComponent = allReports.data.map((report) => {
    return (
      <>
        <p></p>
        <ListGroup as="ul">
          <ListGroup.Item as="li" active>
          Report Number: {report.reportNumber}
          </ListGroup.Item>
          <ListGroup.Item as="li">Address: {report.blockAddress}</ListGroup.Item>
          <ListGroup.Item as="li">Period: {report.offenseStartDateTime} to {report.offenseEndDateTime}</ListGroup.Item>
          <ListGroup.Item as="li">Report Time: {report.reportDateTime}</ListGroup.Item>
          <ListGroup.Item as="li">Crime Type: {report.crimeAgainstCategory}</ListGroup.Item>
          <ListGroup.Item as="li">Crime Detail: {report.offense}</ListGroup.Item>
        </ListGroup>
        
      </>
    );
  });

  return (
    <>
      <div class="jobListDisplay">
        <ListGroup as="ol" numbered>
          {reportListComponent}
        </ListGroup>
      </div>
    </>
  );
}
