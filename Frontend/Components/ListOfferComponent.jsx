import React, { useEffect, useState } from 'react';
import PlacementOfferServices from '../services/PlacementOfferServices';
import { useNavigate } from 'react-router-dom';

const ListItem = ({ offer, onViewDetails }) => (
  <tr key={offer.placement_id}>
    <td>{offer.description}</td>
    <td>{offer.intake}</td>
    <td>{offer.organization}</td>
    <td>{offer.profile}</td>
    <td>
      <button
        className="btn btn-primary"
        onClick={() => onViewDetails(offer.placement_id)}>
        Accept
      </button>
    </td>
  </tr>
);

const ListOfferComponent = () => {
  const [offers, setOffers] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    PlacementOfferServices.getOffers()
      .then((res) => {
        console.log('API Response:', res.data);
        setOffers(res.data);
      })
      .catch((error) => {
        console.error('API Error:', error);
      });
  }, []);

  const viewOfferDetails = (placementId) => {
    // Use navigate to navigate programmatically
    navigate(`/offers/${placementId}`);
  };

  return (
    <div>
      <h2 className="text-center">List of Offers</h2>
      <div className="row">
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th>Description</th>
              <th>Intake</th>
              <th>Organization</th>
              <th>Profile</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {offers.map((offer) => (
              <ListItem
                key={offer.placement_id}
                offer={offer}
                onViewDetails={viewOfferDetails}
              />
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ListOfferComponent;
