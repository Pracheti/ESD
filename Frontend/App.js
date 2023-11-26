import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter as Router, Route, Switch} from 'react-route-dom'
import ListOfferComponent from './Components/ListOfferComponent';
import HeaderComponent from './Components/HeaderComponent';
import FooterComponent from './Components/FooterComponent';

function App() {
  return (
    <div>
      <Router>
        <div>
          <HeaderComponent />
            <div className="container">
              <switch>
                <ListOfferComponent />
              </switch>
            </div>
          <FooterComponent />
        </div>
      </Router>
    </div>
  );
}

export default App;
