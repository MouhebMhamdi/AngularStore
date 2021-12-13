import {Rayon} from "./rayon";
import {Stock} from "./stock";
import {DetailProduit} from "./detailProduit";
import {SubCategory} from "./subCategory";

export class Product{
  idProduit : number;
  code : string;
  libelle : string;
  prixUnitaire : number;
  image: string;
  review : number;
  fournisseurs : string;
  rayon: Rayon;
  stock : Stock;
  qty : number;
  detailProduit : DetailProduit;
  detailFacture : string;
  subCategory:SubCategory;
}
