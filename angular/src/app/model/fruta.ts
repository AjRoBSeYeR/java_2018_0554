

export class Fruta {

    static IMAGEN_DEFAULT = 'https://image.freepik.com/vector-gratis/lema-pina-sandia_41984-19.jpg';
    //atributos privados y comienzan por guion bajo _atributo
    private _id: number;
    private _nombre: string;
    private _precio: number;
    private _oferta: boolean;
    private _descuento: number;
    private _imagen: string;
    private _cantidad: number;
    private _agotada: boolean;
    private _colores : [];



    // constructor solo puede haber uno, no existe sobrecarga como en Java
    // usaremos parametros con ? para opcionales

    /**
     * Obligatorio nombre y precio
     * @param nombre 
     * @param precio 
     * @param id? -1
     * @param oferta valor por defecto false
     * @param descuento? 0
     * @param imagen? const IMAGEN_DEFAULT
     * @param cantidad = 1
     * @param agotada = false
     */
    constructor(
        nombre: string,
        precio: number,
        id?: number,
        oferta = false,
        descuento?: number,
        imagen?: string,
        cantidad = 1,
        agotada = false
    ) {
        this._nombre = nombre;
        this._precio = precio;
        this._id = (id) ? id : -1;
        this._oferta = oferta;
        this._descuento = (descuento) ? descuento : 0;
        this._imagen = (imagen && imagen != '') ? imagen : Fruta.IMAGEN_DEFAULT;
        this._cantidad = cantidad;
        this._agotada = agotada;
    }

    // getters y setters
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }

    public get nombre(): string {
        return this._nombre;
    }
    public set nombre(value: string) {
        this._nombre = value;
    }

    public get precio(): number {
        return this._precio;
    }
    public set precio(value: number) {
        this._precio = value;
    }

    public get oferta(): boolean {
        return this._oferta;
    }
    public set oferta(value: boolean) {
        this._oferta = value;
    }

    public get descuento(): number {
        return this._descuento;
    }
    public set descuento(value: number) {
        this._descuento = value;
    }

    public get imagen(): string {
        if (this._imagen && this._imagen != '') {
            return this._imagen;
        }
        return Fruta.IMAGEN_DEFAULT;
    }
    public set imagen(value: string) {
        if ( this._imagen && this._imagen !='' ) {
            this._imagen = value;
        }
        this._imagen = Fruta.IMAGEN_DEFAULT;
    }

    public get cantidad(): number {
        return this._cantidad;
    }
    public set cantidad(value: number) {
        this._cantidad = value;
    }
    public get agotada(): boolean {
        return this._agotada;
    }
    public set agotada(value: boolean) {
        this._agotada = value;
    }

    // TODO
    jsonMapper(jsonData: any) {

    }

}