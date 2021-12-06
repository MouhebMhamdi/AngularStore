import {subCategory} from "./subCategory";
import {Rayon} from "./rayon";
import {Stock} from "./stock";
import {DetailProduit} from "./detailProduit";

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
  detailProduit : DetailProduit;
  detailFacture : string;
  subCategory: subCategory;
}
