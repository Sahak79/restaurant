package common.data.model;

import common.data.model.converter.OrderStatusConverter;
import common.data.model.lcp.OrderStatus;
import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by SahakBabayan on 6/21/2017.
 */
@Entity
@Table(name = "orders")
public class Orders implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "status_id")
    @Convert(converter = OrderStatusConverter.class)
    private OrderStatus status;

    @Column(name = "table_id")
    private Long table_id;

    @Column(name = "product_id")
    private Long product_id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "table_id", insertable =  false, updatable = false)
    private OrderTable table;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", insertable =  false, updatable = false)
    private Product product;

    @Column(name = "amount")
    private Integer amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Long getTable_id() {
        return table_id;
    }

    public void setTable_id(Long table_id) {
        this.table_id = table_id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public OrderTable getTable() {
        return table;
    }

    public void setTable(OrderTable table) {
        this.table = table;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
