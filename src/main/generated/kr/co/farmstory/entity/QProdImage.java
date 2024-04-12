package kr.co.farmstory.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QProdImage is a Querydsl query type for ProdImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProdImage extends EntityPathBase<ProdImage> {

    private static final long serialVersionUID = -37587997L;

    public static final QProdImage prodImage = new QProdImage("prodImage");

    public final NumberPath<Integer> iNo = createNumber("iNo", Integer.class);

    public final StringPath oName = createString("oName");

    public final NumberPath<Integer> pNo = createNumber("pNo", Integer.class);

    public final StringPath sName = createString("sName");

    public QProdImage(String variable) {
        super(ProdImage.class, forVariable(variable));
    }

    public QProdImage(Path<? extends ProdImage> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProdImage(PathMetadata metadata) {
        super(ProdImage.class, metadata);
    }

}

