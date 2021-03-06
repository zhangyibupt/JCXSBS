package org.cxsbs.core.field;

import java.nio.ByteBuffer;

import org.cxsbs.core.CubeByteBuffer;
import org.cxsbs.core.Vector;

public class HitField extends Field implements IField {

	public HitField(String name) {
		super(name, FieldType.HIT);
	}

	@Override
	public void parse(ByteBuffer buffer, IFieldMap fieldMap) {
		IFieldValue fieldValue = new HitFieldValue(this, 
				CubeByteBuffer.getint(buffer, false), //target
				CubeByteBuffer.getint(buffer, false), //lifesequence
				CubeByteBuffer.getint(buffer, false), //distance
				CubeByteBuffer.getint(buffer, false), //rays
				new Vector( //direction
						CubeByteBuffer.getint(buffer, false), 
						CubeByteBuffer.getint(buffer, false), 
						CubeByteBuffer.getint(buffer, false)));
		fieldMap.put(this, fieldValue);
	}

}
