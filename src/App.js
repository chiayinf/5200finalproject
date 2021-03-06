import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import axios, { Axios } from 'axios';
import { useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import Form from "react-bootstrap/Form";
import ListGroup from "react-bootstrap/ListGroup";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";


function App() {
  const [formInput, setFormInput] = useState('');
  const [yearInput, setYearInput] = useState('');
  const [typeInput, setTypeInput] = useState('');
  const navigate = useNavigate();
  
  return (
    <Container>
        <div class="main">
          <h1>
            Seattle Crime Dashboard
          </h1>
          <img src="data:image/jpeg;base64,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" />
          <Form>
            <Form.Group className="mb-3" controlId="formBasicText">
              <Form.Label ></Form.Label>
              <Form.Control
                type="text"
                placeholder="type a location to search for crime reports in that area"
                value={formInput}
                onChange={(e) => setFormInput(e.target.value)}

              />
            </Form.Group>
          </Form>
          <Button
            variant="primary" onClick={() => navigate('/search/?term=' + formInput)}>
            Search by location
          </Button>

          <Form>
            <Form.Group className="mb-3" controlId="formBasicText">
              <Form.Label ></Form.Label>
              <Form.Control
                type="text"
                placeholder="type a year to search for crime reports in that area"
                value={yearInput}
                onChange={(e) => setYearInput(e.target.value)}

              />
            </Form.Group>
          </Form>
          <Button
            variant="primary" onClick={() => navigate('/search/?term=' + yearInput)}>
            Search by year
          </Button>

          <Form>
            <Form.Group className="mb-3" controlId="formBasicText">
              <Form.Label ></Form.Label>
              <Form.Control
                type="text"
                placeholder="enter PROPERTY or SOCIETY or PERSON to search for crime reports in that area"
                value={typeInput}
                onChange={(e) => setTypeInput(e.target.value)}

              />
            </Form.Group>
          </Form>
          <Button
            variant="primary" onClick={() => navigate('/search/?term=' + typeInput)}>
            Search by type of crime
          </Button>


        </div>
    </Container>
  );
}

export default App;