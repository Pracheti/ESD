import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import ListOfferComponent from './Components/ListOfferComponent';
import HeaderComponent from './Components/HeaderComponent';
import FooterComponent from './Components/FooterComponent';
//import Login from './Layout/Login';
import FillOfferDetails from './Components/FillOfferDetails';

function App() {
  return (
    <div>
      <Router>
        <div>
          <HeaderComponent />
            <div className="container">
              <Routes> 
                <Route path="/offers" element={<ListOfferComponent/>} />
                <Route path="/offers/:placementId" element={<FillOfferDetails />} /> 
              </Routes>
            </div>
          <FooterComponent />
        </div>
      </Router>
    </div>
  );
}

export default App;
