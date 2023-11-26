import React, { Component } from 'react'
import PlacementOfferServices from '../services/PlacementOfferServices'

class ListOfferComponent extends Component {
    constructor(props){
        super(props)
        this.state = {
            offers:[]
        }
    }
    componentDidMount(){
        PlacementOfferServices.getOffers()
        .then((res) => {
            console.log('API Response:', res.data);
            this.setState({offers: res.data});
        })
        .catch((error) => {
            console.error('API Error:', error);
      
        });
    }
    render() {
    return (
        <div>
        <h2 className="text-center">List of Offers</h2>
        <div className="row">
            <table className="table table-striped table bordered">
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Intake</th>
                        <th>Organization</th>
                        <th>Profile</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.offers.map(
                            offers => 
                            <tr key = {offers.placement_id}>
                                <td> {offers.description} </td>
                                <td> {offers.intake} </td>
                                <td> {offers.organization} </td>
                                <td> {offers.profile} </td> 
                            </tr>
                        )
                    }
                </tbody>
            </table> 
        </div>
        </div>
    )
  }
}
export default ListOfferComponent
