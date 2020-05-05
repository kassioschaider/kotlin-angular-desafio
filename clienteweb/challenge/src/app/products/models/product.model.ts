export class Product {

  constructor(
    public productId?: string,
    public title?: string,
    public type?: string,
    public description?: string,
    public filename?: string,
    public height?: number,
    public width?: number,
    public price?: number,
    public rating?: number,
    public created?: Date
  ) { }
}