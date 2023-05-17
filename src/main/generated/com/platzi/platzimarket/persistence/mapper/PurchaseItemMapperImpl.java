package com.platzi.platzimarket.persistence.mapper;

import com.platzi.platzimarket.domain.PurchaseItem;
import com.platzi.platzimarket.persistence.entity.ComprasProducto;
import com.platzi.platzimarket.persistence.entity.ComprasProductoPK;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-16T17:24:48-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
public class PurchaseItemMapperImpl implements PurchaseItemMapper {

    @Override
    public PurchaseItem toPurchaseItem(ComprasProducto product) {
        if ( product == null ) {
            return null;
        }

        PurchaseItem purchaseItem = new PurchaseItem();

        Integer idProducto = productIdIdProducto( product );
        if ( idProducto != null ) {
            purchaseItem.setProductId( idProducto );
        }
        if ( product.getCantidad() != null ) {
            purchaseItem.setQuantity( product.getCantidad() );
        }
        if ( product.getEstado() != null ) {
            purchaseItem.setActive( product.getEstado() );
        }
        if ( product.getTotal() != null ) {
            purchaseItem.setTotal( product.getTotal() );
        }

        return purchaseItem;
    }

    @Override
    public ComprasProducto toComprasProducto(PurchaseItem item) {
        if ( item == null ) {
            return null;
        }

        ComprasProducto comprasProducto = new ComprasProducto();

        comprasProducto.setId( purchaseItemToComprasProductoPK( item ) );
        comprasProducto.setCantidad( item.getQuantity() );
        comprasProducto.setEstado( item.isActive() );
        comprasProducto.setTotal( item.getTotal() );

        return comprasProducto;
    }

    private Integer productIdIdProducto(ComprasProducto comprasProducto) {
        if ( comprasProducto == null ) {
            return null;
        }
        ComprasProductoPK id = comprasProducto.getId();
        if ( id == null ) {
            return null;
        }
        Integer idProducto = id.getIdProducto();
        if ( idProducto == null ) {
            return null;
        }
        return idProducto;
    }

    protected ComprasProductoPK purchaseItemToComprasProductoPK(PurchaseItem purchaseItem) {
        if ( purchaseItem == null ) {
            return null;
        }

        ComprasProductoPK comprasProductoPK = new ComprasProductoPK();

        comprasProductoPK.setIdProducto( purchaseItem.getProductId() );

        return comprasProductoPK;
    }
}
