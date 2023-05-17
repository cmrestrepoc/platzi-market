package com.platzi.platzimarket.persistence.mapper;

import com.platzi.platzimarket.domain.Purchase;
import com.platzi.platzimarket.domain.PurchaseItem;
import com.platzi.platzimarket.persistence.entity.Compra;
import com.platzi.platzimarket.persistence.entity.ComprasProducto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-16T17:28:30-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class PurchaseMapperImpl implements PurchaseMapper {

    @Override
    public Purchase toPurchase(Compra compra) {
        if ( compra == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        if ( compra.getIdCompra() != null ) {
            purchase.setPurchaseId( compra.getIdCompra() );
        }
        if ( compra.getIdCliente() != null ) {
            purchase.setClientId( String.valueOf( compra.getIdCliente() ) );
        }
        purchase.setDate( compra.getFecha() );
        purchase.setPaymentMethod( compra.getMedioPago() );
        purchase.setComment( compra.getComentario() );
        purchase.setState( compra.getEstado() );
        purchase.setItems( comprasProductoListToPurchaseItemList( compra.getProductos() ) );

        return purchase;
    }

    @Override
    public List<Purchase> toPurchases(List<Compra> compras) {
        if ( compras == null ) {
            return null;
        }

        List<Purchase> list = new ArrayList<Purchase>( compras.size() );
        for ( Compra compra : compras ) {
            list.add( toPurchase( compra ) );
        }

        return list;
    }

    @Override
    public Compra toCompra(Purchase purchase) {
        if ( purchase == null ) {
            return null;
        }

        Compra compra = new Compra();

        compra.setIdCompra( purchase.getPurchaseId() );
        if ( purchase.getClientId() != null ) {
            compra.setIdCliente( Integer.parseInt( purchase.getClientId() ) );
        }
        compra.setFecha( purchase.getDate() );
        compra.setMedioPago( purchase.getPaymentMethod() );
        compra.setComentario( purchase.getComment() );
        compra.setEstado( purchase.getState() );
        compra.setProductos( purchaseItemListToComprasProductoList( purchase.getItems() ) );

        return compra;
    }

    protected PurchaseItem comprasProductoToPurchaseItem(ComprasProducto comprasProducto) {
        if ( comprasProducto == null ) {
            return null;
        }

        PurchaseItem purchaseItem = new PurchaseItem();

        if ( comprasProducto.getTotal() != null ) {
            purchaseItem.setTotal( comprasProducto.getTotal() );
        }

        return purchaseItem;
    }

    protected List<PurchaseItem> comprasProductoListToPurchaseItemList(List<ComprasProducto> list) {
        if ( list == null ) {
            return null;
        }

        List<PurchaseItem> list1 = new ArrayList<PurchaseItem>( list.size() );
        for ( ComprasProducto comprasProducto : list ) {
            list1.add( comprasProductoToPurchaseItem( comprasProducto ) );
        }

        return list1;
    }

    protected ComprasProducto purchaseItemToComprasProducto(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        ComprasProducto comprasProducto = new ComprasProducto();

        comprasProducto.setTotal( purchaseItem.getTotal() );

        return comprasProducto;
    }

    protected List<ComprasProducto> purchaseItemListToComprasProductoList(List<PurchaseItem> list) {
        if ( list == null ) {
            return null;
        }

        List<ComprasProducto> list1 = new ArrayList<ComprasProducto>( list.size() );
        for ( PurchaseItem purchaseItem : list ) {
            list1.add( purchaseItemToComprasProducto( purchaseItem ) );
        }

        return list1;
    }
}
