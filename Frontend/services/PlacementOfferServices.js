import axios from 'axios'
const OFFERS_URL = "http://localhost:9191/offers/3.1/CSE/SDE"
class PlacementOfferServices{
    getOffers(){
        return axios.get(OFFERS_URL);
    }
}
export default new PlacementOfferServices()
